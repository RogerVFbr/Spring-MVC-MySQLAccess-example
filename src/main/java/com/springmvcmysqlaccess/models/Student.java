package com.springmvcmysqlaccess.models;

public class Student {
    private int studentid;
    private String birthdate;
    private int userid_fk;
    private int courseid_fk;

    public Student() {}

    public Student(int studentid, String birthdate, int userid_fk, int courseid_fk) {
        this.studentid = studentid;
        this.birthdate = birthdate;
        this.userid_fk = userid_fk;
        this.courseid_fk = courseid_fk;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getUserid_fk() {
        return userid_fk;
    }

    public void setUserid_fk(int userid_fk) {
        this.userid_fk = userid_fk;
    }

    public int getCourseid_fk() {
        return courseid_fk;
    }

    public void setCourseid_fk(int courseid_fk) {
        this.courseid_fk = courseid_fk;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentid +
                ", birthdate='" + birthdate + '\'' +
                ", userid_fk=" + userid_fk +
                ", courseid_fk=" + courseid_fk +
                '}';
    }
}
