package com.example.kitchenette;

public class Users {

    private  String uid;
    private String full_name;
    private String email;
    private String phone;
    private String password;
    private int role;

    public Users(){

    }

    public Users(String uid, String full_name, String email, String phone, String password, int role) {
        this.uid = uid;
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
