package com.example.bakhtiyar.campusrecruitmentsystem;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AdminPanel extends AppCompatActivity {

    ViewPager viewPager;

    AdminFragmentPagerAdapter adminFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        viewPager = (ViewPager) findViewById(R.id.vp);

        adminFragmentPagerAdapter = new AdminFragmentPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adminFragmentPagerAdapter);

    }
}
