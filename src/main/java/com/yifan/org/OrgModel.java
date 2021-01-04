package com.yifan.org;

import java.util.ArrayList;
import java.util.List;

public class OrgModel {

    private Integer orgId;

    private String orgName;

    private Integer orgEmpNum = 0;

    private String orgIdPath;

    private List<OrgModel> childOrgList = new ArrayList<>();

    private List<Object> empList = new ArrayList<>();

    public OrgModel(Integer orgId, String orgName, String orgIdPath) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.orgIdPath = orgIdPath;
    }

    public OrgModel(Integer orgId, String orgName) {
        this.orgId = orgId;
        this.orgName = orgName;
    }

    public OrgModel() {
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getOrgEmpNum() {
        return orgEmpNum;
    }

    public void setOrgEmpNum(Integer orgEmpNum) {
        this.orgEmpNum = orgEmpNum;
    }

    public List<OrgModel> getChildOrgList() {
        return childOrgList;
    }

    public void setChildOrgList(List<OrgModel> childOrgList) {
        this.childOrgList = childOrgList;
    }

    public List<Object> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Object> empList) {
        this.empList = empList;
    }

    public String getOrgIdPath() {
        return orgIdPath;
    }

    public void setOrgIdPath(String orgIdPath) {
        this.orgIdPath = orgIdPath;
    }

    @Override
    public String toString() {
        return orgName +
        "  " + orgId +
        "  " + orgEmpNum + "  " + orgIdPath;
    }
}
