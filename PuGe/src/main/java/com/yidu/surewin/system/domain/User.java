package com.yidu.surewin.system.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class User implements Serializable {

    private static final long serialVersionUID = 1091732343023429328L;

    private String userid;

    private String username;

    private String password;

    private String salt;

    private String organizationid;

    private String organizatinname;

    private String phonenumber;

    private String useabe;

    private String birthdate;

    private String gender;

    private String description;

    private String remark1;

    private String remark2;

    public User() {
    }

    public User(String userid, String username, String password, String salt, String organizationid, String organizatinname, String phonenumber, String useabe, String birthdate, String gender, String description, String remark1, String remark2) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.organizationid = organizationid;
        this.organizatinname = organizatinname;
        this.phonenumber = phonenumber;
        this.useabe = useabe;
        this.birthdate = birthdate;
        this.gender = gender;
        this.description = description;
        this.remark1 = remark1;
        this.remark2 = remark2;
    }

    public User(String username, String organizationid, String phonenumber, String useabe, String gender) {
        this.username = username;
        this.organizationid = organizationid;
        this.phonenumber = phonenumber;
        this.useabe = useabe;
        this.gender = gender;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(String organizationid) {
        this.organizationid = organizationid;
    }

    public String getOrganizatinname() {
        return organizatinname;
    }

    public void setOrganizatinname(String organizatinname) {
        this.organizatinname = organizatinname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUseabe() {
        return useabe;
    }

    public void setUseabe(String useabe) {
        this.useabe = useabe;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", organizationid='" + organizationid + '\'' +
                ", organizatinname='" + organizatinname + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", useabe='" + useabe + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", gender='" + gender + '\'' +
                ", description='" + description + '\'' +
                ", remark1='" + remark1 + '\'' +
                ", remark2='" + remark2 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userid, user.userid) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(salt, user.salt) &&
                Objects.equals(organizationid, user.organizationid) &&
                Objects.equals(organizatinname, user.organizatinname) &&
                Objects.equals(phonenumber, user.phonenumber) &&
                Objects.equals(useabe, user.useabe) &&
                Objects.equals(birthdate, user.birthdate) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(description, user.description) &&
                Objects.equals(remark1, user.remark1) &&
                Objects.equals(remark2, user.remark2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userid, username, password, salt, organizationid, organizatinname, phonenumber, useabe, birthdate, gender, description, remark1, remark2);
    }
}