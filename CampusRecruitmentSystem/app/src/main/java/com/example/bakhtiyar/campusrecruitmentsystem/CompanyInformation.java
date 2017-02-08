package com.example.bakhtiyar.campusrecruitmentsystem;

/**
 * Created by Bakhtiyar on 1/28/2017.
 */
public class CompanyInformation {

    String name, email,uid;

    public CompanyInformation(String name, String email,String uid) {
        this.name = name;
        this.email = email;
        this.uid = uid;
    }

    public CompanyInformation() {
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
