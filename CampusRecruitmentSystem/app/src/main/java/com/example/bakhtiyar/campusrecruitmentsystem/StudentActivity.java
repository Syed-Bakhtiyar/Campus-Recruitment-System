package com.example.bakhtiyar.campusrecruitmentsystem;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StudentActivity extends AppCompatActivity {

    TabLayout tabLayout;

    ViewPager viewPager;

    StudentFragmentAdapter studentFragmentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        studentFragmentAdapter = new StudentFragmentAdapter(getSupportFragmentManager());


        viewPager = (ViewPager) findViewById(R.id.vp);


        viewPager.setAdapter(studentFragmentAdapter);



    }
}
