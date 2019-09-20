package com.springmvcmysqlaccess.models;

public class Teacher {
    private int teacherid;
    private String title;
    private Integer userid_fk;
    private String name;

    public Teacher() {}

    public Teacher(int teacherid, String title, Integer userid_fk, String name) {
        this.teacherid = teacherid;
        this.title = title;
        this.userid_fk = userid_fk;
        this.name = name;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
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

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherid=" + teacherid +
                ", title='" + title + '\'' +
                ", userid_fk=" + userid_fk +
                ", name=" + name +
                '}';
    }
}
