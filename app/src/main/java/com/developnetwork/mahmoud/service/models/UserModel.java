package com.developnetwork.mahmoud.service.models;

public class UserModel {
    private String phone;
    private String pass;
    private String token;
    private String name;


    public UserModel(String name, String phone, String pass, String token) {
        this.name = name;
        this.phone = phone;
        this.pass = pass;
        this.token = token;
    }

    public UserModel(String phone, String pass, String token) {
        this.phone = phone;
        this.pass = pass;
        this.token = token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "phone='" + phone + '\'' +
                ", pass='" + pass + '\'' +
                ", token='" + token + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
