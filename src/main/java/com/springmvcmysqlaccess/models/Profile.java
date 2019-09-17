package com.springmvcmysqlaccess.models;

public class Profile {
    private int profileid;
    private String profilename;

    public Profile() {}

    public Profile(int profileid, String profilename) {
        this.profileid = profileid;
        this.profilename = profilename;
    }

    public int getProfileid() {
        return profileid;
    }

    public void setProfileid(int profileid) {
        this.profileid = profileid;
    }

    public String getProfilename() {
        return profilename;
    }

    public void setProfilename(String profilename) {
        this.profilename = profilename;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileid=" + profileid +
                ", profilename='" + profilename + '\'' +
                '}';
    }
}
