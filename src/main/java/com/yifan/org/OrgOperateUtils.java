package com.yifan.org;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * The type Org operate utils.
 */
public class OrgOperateUtils {

    public static void printOrg(OrgModel root) {
        System.out.println(root);
        List<OrgModel> childList = root.getChildOrgList();
        if (!CollectionUtils.isEmpty(childList)) {
            for (OrgModel orgModel : childList) {
                printOrg(orgModel);
            }
        }
    }

    /**
     * 添加新组织
     *
     * @param parent the parent
     * @param newOrg the new org
     */
    public static void addOrg(OrgModel parent, OrgModel newOrg) {
        // 取出parent的人员列表
        List<Object> empList = parent.getEmpList();
        // 清除parent的人
        parent.setEmpList(new ArrayList<>());

        String orgIdPath = parent.getOrgIdPath();

        // parent添加组织
        parent.getChildOrgList().add(newOrg);
        newOrg.getEmpList().addAll(empList);
        newOrg.setOrgIdPath(orgIdPath + newOrg.getOrgId() + "/");
    }

    /**
     * 移除组织
     *
     * @param root   the root
     * @param org    the org
     */
    public static void removeOrg(OrgModel root, OrgModel org) {
        OrgModel parent = findParent(root, org);
        if (parent == null) {
            throw new RuntimeException("org do not have parent in root");
        }
        // parent中移除org
        parent.getChildOrgList().remove(org);

        // 减去parent的数量
        subEmpNum(root, org.getOrgEmpNum(), parent.getOrgIdPath(), parent);
    }

    /**
     * 增加组织
     *
     * @param root    the root
     * @param org     the org
     * @param empList the emp list
     */
    public static void addEmp(OrgModel root, OrgModel org, List<Object> empList) {

        // 增加人
        org.getEmpList().addAll(empList);

        // 增加父组织人数
        addEmpNum(root, empList.size(), org.getOrgIdPath(), org);
    }

    /**
     * 移除人数
     *
     * @param root    the root
     * @param org     the org
     * @param empList the emp list
     */
    public static void removeEmp(OrgModel root, OrgModel org, List<Object> empList) {
        // 移除人
        int num = 0;
        Iterator<Object> iterator = org.getEmpList().iterator();
        while (iterator.hasNext()) {
            Object emp = iterator.next();
            if (empList.contains(emp)) {
                iterator.remove();
                num++;
            }
        }

        // 删除父组织人数
        subEmpNum(root, num, org.getOrgIdPath(), org);
    }

    /**
     * 移动人员
     *
     * @param root    the root
     * @param from    the from
     * @param to      the to
     * @param empList the emp list
     */
    public static void moveEmp(OrgModel root, OrgModel from, OrgModel to, List<Object> empList) {
        // 删除form的人
        removeEmp(root, from, empList);

        // 增加to的人
        addEmp(root, to, empList);
    }

    private static void subEmpNum(OrgModel org, int empNum, String orgIdPaths, OrgModel target) {

        // 不在组织路径表名跟改组织无任何关系，直接返回
        if (!orgIdPaths.contains("/" + org.getOrgId() + "/")) {
            return;
        } else {
            // 更新人员数量
            org.setOrgEmpNum(org.getOrgEmpNum() - empNum);
        }

        // 递归到目标节点结束
        if (org.equals(target)) {
            return;
        }

        List<OrgModel> orgModels = org.getChildOrgList();
        if (!CollectionUtils.isEmpty(orgModels)) {
            for (OrgModel orgModel : orgModels) {
                subEmpNum(orgModel, empNum, orgIdPaths, target);
            }
        }
    }

    private static void addEmpNum(OrgModel org, int empNum, String orgIdPaths, OrgModel target) {

        // 不在组织路径表名跟改组织无任何关系，直接返回
        if (!orgIdPaths.contains("/" + org.getOrgId() + "/")) {
            return;
        } else {
            // 更新人员数量
            org.setOrgEmpNum(org.getOrgEmpNum() + empNum);
        }
        // 递归到目标节点结束
        if (org.equals(target)) {
            return;
        }

        List<OrgModel> orgModels = org.getChildOrgList();
        if (!CollectionUtils.isEmpty(orgModels)) {
            for (OrgModel orgModel : orgModels) {
                addEmpNum(orgModel, empNum, orgIdPaths, target);
            }
        }
    }

    private static OrgModel findParent(OrgModel root, OrgModel target) {
        String parentOrgIdPath = target.getOrgIdPath().replace(target.getOrgId() + "/", "");
        LinkedList<OrgModel> queue = new LinkedList<>();
        queue.add(root);
        return findParent(queue, parentOrgIdPath);
    }

    private static OrgModel findParent(LinkedList<OrgModel> queue, String parentOrgIdPath) {
        while (!queue.isEmpty()) {
            OrgModel orgModel = queue.poll();
            if (orgModel.getOrgIdPath().equals(parentOrgIdPath)) {
                return orgModel;
            }
            List<OrgModel> childList = orgModel.getChildOrgList();
            for (OrgModel model : childList) {
                if (parentOrgIdPath.contains("/" + model.getOrgId() + "/")) {
                    queue.push(model);
                }
            }
        }

        return null;
    }

    private static void sub2(List<OrgModel> list) {
        List<String> strings = new ArrayList<>();

        list.sort(Comparator.comparing(org -> org.getOrgIdPath().length()));

        Iterator<OrgModel> iterator = list.iterator();
        while (iterator.hasNext()) {
            OrgModel orgModel = iterator.next();
            String orgIdPath = orgModel.getOrgIdPath();

            if (strings.stream().anyMatch(orgIdPath::startsWith)) {
                iterator.remove();
                continue;
            }

            strings.add(orgIdPath);
        }
    }

    private static void sub(List<String> list) {
        List<String> strings = new ArrayList<>();

        list.sort(Comparator.comparing(String::length));

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String orgIdPath = iterator.next();
            if (strings.stream().anyMatch(orgIdPath::startsWith)) {
                iterator.remove();
                continue;
            }
            strings.add(orgIdPath);
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("/10000/10002/10006/10010/");
        list.add("/10000/10001/10003/");
        list.add("/10000/10001/10003/10007/");
        list.add("/10000/10002/");
        list.add("/10000/10002/");
        list.add("/10000/10002/10006/");
        sub(list);
        System.out.println(JSONObject.toJSONString(list));
    }
}
