package com.example.bakhtiyar.campusrecruitmentsystem;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CampusActivity extends AppCompatActivity {

    ViewPager viewPager;

    CampusFragmentAdapter campusFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus);

        campusFragmentAdapter = new CampusFragmentAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.vp);


        viewPager.setAdapter(campusFragmentAdapter);
    }
}
