package com.springmvcmysqlaccess.models;

import java.util.Objects;

public class User {
    private int userid;
    private int enrollment;
    private String name;
    private String password;
    private String email;
    private int profileid_fk;
    private String isteacher;

    public User() {}

    public User(int userid, int enrollment, String name, String password, String email, int profileid_fk, String isteacher) {
        this.userid = userid;
        this.enrollment = enrollment;
        this.name = name;
        this.password = password;
        this.email = email;
        this.profileid_fk = profileid_fk;
        this.isteacher = isteacher;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getProfileid_fk() {
        return profileid_fk;
    }

    public void setProfileid_fk(int profileid_fk) {
        this.profileid_fk = profileid_fk;
    }

    public String getIsteacher() {
        return isteacher;
    }

    public void setIsteacher(String isteacher) {
        this.isteacher = isteacher;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", enrollment=" + enrollment +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", profileid_fk=" + profileid_fk +
                ", isteacher=" + isteacher +
                '}';
    }
}
