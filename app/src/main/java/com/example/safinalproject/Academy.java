package com.example.safinalproject;

public class Academy {
    private String centerName;
    private String email;
    private String phone;
    private String location;
    private String place;

    public Academy(String centerName, String email, String phone, String location, String place) {
        this.centerName = centerName;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.place = place;
    }

    public String getCenterName() {
        return centerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLocation() {
        return location;
    }

    public String getPlace() {
        return place;
    }
}
