package com.yifan.org;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        OrgModel root = new OrgModel(10000, "新奥顶级", "/10000/");

        OrgModel org1 = new OrgModel(10001, "新奥新智");
        OrgOperateUtils.addOrg(root, org1);
        OrgModel org2 = new OrgModel(10002, "新奥能源");
        OrgOperateUtils.addOrg(root, org2);
        OrgModel org3 = new OrgModel(10003, "自驱组织");
        OrgOperateUtils.addOrg(org1, org3);
        OrgModel org4 = new OrgModel(10004, "业务理正");
        OrgOperateUtils.addOrg(org1, org4);
        OrgModel org5 = new OrgModel(10005, "党工团哈");
        OrgOperateUtils.addOrg(org2, org5);
        OrgModel org6 = new OrgModel(10006, "自驱组织");
        OrgOperateUtils.addOrg(org2, org6);
        OrgModel org7 = new OrgModel(10007, "智慧产业");
        OrgOperateUtils.addOrg(org3, org7);
        OrgModel org8 = new OrgModel(10008, "新博卓畅");
        OrgOperateUtils.addOrg(org4, org8);
        OrgModel org9 = new OrgModel(10009, "张朋专用");
        OrgOperateUtils.addOrg(org5, org9);
        OrgModel org10 = new OrgModel(10010, "是年终奖");
        OrgOperateUtils.addOrg(org6, org10);

        OrgOperateUtils.printOrg(root);

        System.out.println("----------------------------");

        List<Object> empList = Arrays.asList(1, 2, 3, 4);
        List<Object> empList1 = Arrays.asList(5, 6, 7, 8);

        OrgOperateUtils.addEmp(root, org10, empList);

        OrgOperateUtils.printOrg(root);
        System.out.println("----------------------------");

        OrgOperateUtils.addEmp(root, org9, empList1);

        OrgOperateUtils.printOrg(root);
        System.out.println("----------------------------");

        OrgOperateUtils.removeOrg(root, org9);
        OrgOperateUtils.printOrg(root);
    }
}
