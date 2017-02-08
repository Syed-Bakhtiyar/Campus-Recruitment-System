package com.example.bakhtiyar.campusrecruitmentsystem;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Junaid on 1/26/2017.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){

            case 0:

                return "Students";

            case 1:

                return "Admin";

            case 2:

                return "Company";
            default:

                return null;


        }
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:

                return new StudentLogin();

            case 1:

                return new AdminLogin();

            case 2:

                return new CompanyLogin();
            default:

                return null;


        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
