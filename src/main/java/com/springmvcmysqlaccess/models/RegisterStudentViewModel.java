package com.springmvcmysqlaccess.models;

public class RegisterStudentViewModel extends User{
    private String birthdate;
    private int courseid_fk;
    private int enrollment;
    private String name;
    private String password;
    private String email;
    private int profileid_fk;

    public RegisterStudentViewModel() {}

    public RegisterStudentViewModel(String birthdate, int courseid_fk, int enrollment, String name, String password, String email, int profileid_fk) {
        this.birthdate = birthdate;
        this.courseid_fk = courseid_fk;
        this.enrollment = enrollment;
        this.name = name;
        this.password = password;
        this.email = email;
        this.profileid_fk = profileid_fk;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
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
        return "RegisterStudentViewModel{" +
                "birthdate='" + birthdate + '\'' +
                ", courseid_fk=" + courseid_fk +
                ", enrollment=" + enrollment +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", profileid_fk=" + profileid_fk +
                '}';
    }
}
