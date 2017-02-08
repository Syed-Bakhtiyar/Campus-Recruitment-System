package com.example.bakhtiyar.campusrecruitmentsystem;

/**
 * Created by Bakhtiyar on 1/28/2017.
 */
public class ApplyVacancy {
    String name, qualification, lastyear, skills,experience, date, uuid, key;



    public ApplyVacancy(String name, String qualification, String lastyear, String skills, String experience, String date, String uuid, String key) {

        this.name = name;
        this.qualification = qualification;
        this.lastyear = lastyear;
        this.skills = skills;
        this.experience = experience;
        this.date = date;
        this.uuid = uuid;
        this.key = key;
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

    public String getDate() {
        return date;
    }

    public String getUuid() {
        return uuid;
    }

    public String getKey() {
        return key;
    }

    public ApplyVacancy() {

    }


}
