package com.example.bakhtiyar.campusrecruitmentsystem;

/**
 * Created by Junaid on 1/26/2017.
 */

public class StudentInformation {


    String name, qualification, lastyear, skills,experience,uid;

    public StudentInformation(String name, String qualification, String lastyear, String skills, String experience,String uid) {
        this.name = name;
        this.qualification = qualification;
        this.lastyear = lastyear;
        this.skills = skills;
        this.experience = experience;
        this.uid = uid;
    }

    public StudentInformation() {
    }


    public String getName() {
        return name;
    }

    public String getQualification() {
        return qualification;
    }

    public String getLastyear() {
        return lastyear;
    }

    public String getSkills() {
        return skills;
    }

    public String getExperience() {
        return experience;
    }

    public String getUid() {
        return uid;
    }
}
