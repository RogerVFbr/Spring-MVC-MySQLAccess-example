package com.springmvcmysqlaccess.models;

public class Subject {
    private int subjectid;
    private String subjectcode;
    private String subjectname;
    private int courseid_fk;

    public Subject() {}

    public Subject(int subjectid, String subjectcode, String subjectname, int courseid_fk) {
        this.subjectid = subjectid;
        this.subjectcode = subjectcode;
        this.subjectname = subjectname;
        this.courseid_fk = courseid_fk;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public String getSubjectcode() {
        return subjectcode;
    }

    public void setSubjectcode(String subjectcode) {
        this.subjectcode = subjectcode;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public int getCourseid_fk() {
        return courseid_fk;
    }

    public void setCourseid_fk(int courseid_fk) {
        this.courseid_fk = courseid_fk;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectid=" + subjectid +
                ", subjectcode='" + subjectcode + '\'' +
                ", subjectname='" + subjectname + '\'' +
                ", courseid_fk=" + courseid_fk +
                '}';
    }
}
