package com.example.bakhtiyar.campusrecruitmentsystem;

/**
 * Created by Bakhtiyar on 1/28/2017.
 */
public class DoneVacanciesClass {

    String interview, date, uuid, pushkey;

    public String getInterview() {
        return interview;
    }

    public String getDate() {
        return date;
    }

    public String getUuid() {
        return uuid;
    }

    public String getPushkey() {
        return pushkey;
    }

    public DoneVacanciesClass() {

    }

    public DoneVacanciesClass(String interview, String date, String uuid, String pushkey) {
        this.interview = interview;
        this.date = date;
        this.uuid = uuid;
        this.pushkey = pushkey;
    }
}
