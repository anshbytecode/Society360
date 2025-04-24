package com.example.society360;

public class ResidentModel {
    private int id;
    private String name;
    private String flatNo;
    private String phoneNumber;

    public ResidentModel(int id,String name, String flat_no, String phone_number) {
        this.id = id;
        this.name = name;
        this.flatNo = flat_no;
        this.phoneNumber = phone_number;
    }

    public int getid() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}