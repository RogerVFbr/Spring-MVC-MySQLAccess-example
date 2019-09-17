package com.springmvcmysqlaccess.models;

public class ClassMdl {
    private int classid;
    private String classcode;
    private String classroom;
    private int subjectid_fk;
    private int teacherid_fk;

    public ClassMdl() {}

    public ClassMdl(int classid, String classcode, String classroom, int subjectid_fk, int teacherid_fk) {
        this.classid = classid;
        this.classcode = classcode;
        this.classroom = classroom;
        this.subjectid_fk = subjectid_fk;
        this.teacherid_fk = teacherid_fk;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getSubjectid_fk() {
        return subjectid_fk;
    }

    public void setSubjectid_fk(int subjectid_fk) {
        this.subjectid_fk = subjectid_fk;
    }

    public int getTeacherid_fk() {
        return teacherid_fk;
    }

    public void setTeacherid_fk(int teacherid_fk) {
        this.teacherid_fk = teacherid_fk;
    }

    @Override
    public String toString() {
        return "ClassMdl{" +
                "classid=" + classid +
                ", classcode='" + classcode + '\'' +
                ", classroom='" + classroom + '\'' +
                ", subjectid_fk=" + subjectid_fk +
                ", teacherid_fk=" + teacherid_fk +
                '}';
    }
}
