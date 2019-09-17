package com.springmvcmysqlaccess.models;

public class Course {
    private int courseid;
    private String coursename;

    public Course() {}

    public Course(int courseid, String coursename) {
        this.courseid = courseid;
        this.coursename = coursename;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseid=" + courseid +
                ", coursename='" + coursename + '\'' +
                '}';
    }
}
