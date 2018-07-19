package com.yidu.surewin.system.domain;

import java.io.Serializable;
import java.util.Objects;

public class Organization implements Serializable {

    private static final long serialVersionUID = -8786070328167011894L;

    private String organizationid;

    private String organizatinname;

    private String parentid;

    private String parentname;

    private String description;

    private String address;

    private String connectphone;

    private String managerid;

    private String managername;

    private String organizationtype;

    private String remark1;

    private String remark2;

    public String getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(String organizationid) {
        this.organizationid = organizationid == null ? null : organizationid.trim();
    }

    public String getOrganizatinname() {
        return organizatinname;
    }

    public void setOrganizatinname(String organizatinname) {
        this.organizatinname = organizatinname == null ? null : organizatinname.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname == null ? null : parentname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getConnectphone() {
        return connectphone;
    }

    public void setConnectphone(String connectphone) {
        this.connectphone = connectphone == null ? null : connectphone.trim();
    }

    public String getManagerid() {
        return managerid;
    }

    public void setManagerid(String managerid) {
        this.managerid = managerid == null ? null : managerid.trim();
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername == null ? null : managername.trim();
    }

    public String getOrganizationtype() {
        return organizationtype;
    }

    public void setOrganizationtype(String organizationtype) {
        this.organizationtype = organizationtype == null ? null : organizationtype.trim();
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    @Override
    public String toString() {
        return "Organization{" +
                "organizationid='" + organizationid + '\'' +
                ", organizatinname='" + organizatinname + '\'' +
                ", parentid='" + parentid + '\'' +
                ", parentname='" + parentname + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", connectphone='" + connectphone + '\'' +
                ", managerid='" + managerid + '\'' +
                ", managername='" + managername + '\'' +
                ", organizationtype='" + organizationtype + '\'' +
                ", remark1='" + remark1 + '\'' +
                ", remark2='" + remark2 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(organizationid, that.organizationid) &&
                Objects.equals(organizatinname, that.organizatinname) &&
                Objects.equals(parentid, that.parentid) &&
                Objects.equals(parentname, that.parentname) &&
                Objects.equals(description, that.description) &&
                Objects.equals(address, that.address) &&
                Objects.equals(connectphone, that.connectphone) &&
                Objects.equals(managerid, that.managerid) &&
                Objects.equals(managername, that.managername) &&
                Objects.equals(organizationtype, that.organizationtype) &&
                Objects.equals(remark1, that.remark1) &&
                Objects.equals(remark2, that.remark2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(organizationid, organizatinname, parentid, parentname, description, address, connectphone, managerid, managername, organizationtype, remark1, remark2);
    }
}