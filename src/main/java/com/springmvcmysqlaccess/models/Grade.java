package com.springmvcmysqlaccess.models;

public class Grade {
    private int gradeid;
    private float av1;
    private float av2;
    private int studentid_fk;
    private int classid_fk;
    private String classcode;

    public Grade() {}

    public Grade(int gradeid, Float av1, Float av2, int studentid_fk, int classid_fk, String classcode) {
        this.gradeid = gradeid;
        this.av1 = av1;
        this.av2 = av2;
        this.studentid_fk = studentid_fk;
        this.classid_fk = classid_fk;
        this.classcode = classcode;
    }

    public int getGradeid() {
        return gradeid;
    }

    public void setGradeid(int gradeid) {
        this.gradeid = gradeid;
    }

    public float getAv1() {
        return av1;
    }

    public void setAv1(float av1) {
        this.av1 = av1;
    }

    public float getAv2() {
        return av2;
    }

    public void setAv2(float av2) {
        this.av2 = av2;
    }

    public int getStudentid_fk() {
        return studentid_fk;
    }

    public void setStudentid_fk(int studentid_fk) {
        this.studentid_fk = studentid_fk;
    }

    public int getClassid_fk() {
        return classid_fk;
    }

    public void setClassid_fk(int classid_fk) {
        this.classid_fk = classid_fk;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeid=" + gradeid +
                ", av1=" + av1 +
                ", av2=" + av2 +
                ", studentid_fk=" + studentid_fk +
                ", classid_fk=" + classid_fk +
                ", classcode=" + classcode +
                '}';
    }
}
