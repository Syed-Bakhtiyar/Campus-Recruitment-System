package com.example.bakhtiyar.campusrecruitmentsystem;

/**
 * Created by Bakhtiyar on 1/28/2017.
 */
public class CompanyJobsRequirement {
    String name;

    String job;

    String skills;

    String qualification;

    String experience;

    String pushKey;

    String uid;

    public CompanyJobsRequirement(String job, String skills, String qualification, String experience, String pushKey,String name,String uid) {
        this.job = job;
        this.skills = skills;
        this.qualification = qualification;
        this.experience = experience;
        this.pushKey = pushKey;
        this.name= name;
        this.uid = uid;

    }




    public CompanyJobsRequirement() {
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getSkills() {
        return skills;
    }

    public String getQualification() {
        return qualification;
    }

    public String getExperience() {
        return experience;
    }

    public String getPushKey() {
        return pushKey;
    }

    public String getUid() {
        return uid;
    }
}
