package com.springmvcmysqlaccess.models;

public class TeacherUserViewModel extends User {
    private int teacherid;
    private String title;
    private Integer userid_fk;
    private int userid;
    private String name;
    private int enrollment;
    private String password;
    private String email;
    private int profileid_fk;

    public TeacherUserViewModel() {}

    public TeacherUserViewModel(int teacherid, String title, Integer userid_fk, int userid, String name, int enrollment, String password, String email, int profileid_fk) {
        this.teacherid = teacherid;
        this.title = title;
        this.userid_fk = userid_fk;
        this.userid = userid;
        this.name = name;
        this.enrollment = enrollment;
        this.password = password;
        this.email = email;
        this.profileid_fk = profileid_fk;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUserid_fk() {
        return userid_fk;
    }

    public void setUserid_fk(Integer userid_fk) {
        this.userid_fk = userid_fk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
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

    public int getTeacherid() { return teacherid; }

    public void setTeacherid(int teacherid) { this.teacherid = teacherid; }

    @Override
    public int getUserid() { return userid; }

    public void setUserid(int userid) { this.userid = userid; }

    @Override
    public String toString() {
        return "TeacherUserViewModel{" +
                "teacherid='" + teacherid + '\'' +
                ", title='" + title + '\'' +
                ", userid_fk=" + userid_fk +
                ", userid=" + userid +
                ", name='" + name + '\'' +
                ", enrollment=" + enrollment +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", profileid_fk=" + profileid_fk +
                '}';
    }
}
