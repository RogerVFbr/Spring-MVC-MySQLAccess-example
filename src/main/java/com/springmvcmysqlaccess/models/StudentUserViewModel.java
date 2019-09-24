package com.springmvcmysqlaccess.models;

public class StudentUserViewModel extends User{
    private int studentid;
    private String birthdate;
    private int userid_fk;
    private int courseid_fk;
    private int enrollment;
    private String name;
    private String password;
    private String email;
    private int profileid_fk;

    public StudentUserViewModel() {}

    public StudentUserViewModel(int studentid, String birthdate, int userid_fk, int courseid_fk, int enrollment,
                                String name, String password, String email, int profileid_fk) {
        this.studentid = studentid;
        this.birthdate = birthdate;
        this.userid_fk = userid_fk;
        this.courseid_fk = courseid_fk;
        this.enrollment = enrollment;
        this.name = name;
        this.password = password;
        this.email = email;
        this.profileid_fk = profileid_fk;
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

    @Override
    public String toString() {
        return "StudentUserViewModel{" +
                "studentid='" + studentid + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", userid_fk='" + userid_fk + '\'' +
                ", courseid_fk=" + courseid_fk +
                ", enrollment=" + enrollment +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", profileid_fk=" + profileid_fk +
                '}';
    }
}
