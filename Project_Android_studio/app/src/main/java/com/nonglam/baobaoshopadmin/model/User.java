package com.nonglam.baobaoshopadmin.model;

public class User {
    private String role;
    private String phone;
    private String password;
    private String name;
    private String token;

    public User(String role, String phone, String name, String token) {
        this.role = role;
        this.phone = phone;
        this.name = name;
        this.token = token;
    }

    public User(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
