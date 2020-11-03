package com.aditya.travelapp.models;

public class TrackModel {
    private String user_name,ip,login_date;

    public TrackModel() {
    }

    public TrackModel(String user_name, String ip, String login_date) {
        this.user_name = user_name;
        this.ip = ip;
        this.login_date = login_date;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLogin_date() {
        return login_date;
    }

    public void setLogin_date(String login_date) {
        this.login_date = login_date;
    }
}
