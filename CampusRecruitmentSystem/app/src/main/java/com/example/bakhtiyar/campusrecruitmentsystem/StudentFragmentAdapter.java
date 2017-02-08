package com.example.bakhtiyar.campusrecruitmentsystem;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Created by Junaid on 1/26/2017.
 */

public class StudentFragmentAdapter extends FragmentPagerAdapter {
    public StudentFragmentAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:

                return "Add My Resume";

            case 1:

                return "See  My Resume";

            case 2:

                return "View All Companies ";

            case 3:

                return "View All jobs";
            case 4:
                return "View Approval";

            default:

                return null;
        }
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                Log.d("position", "getItem: "+position);
                return new StudentWriteResumeFragment();

            case 1:
                return new StudentsViewProfileFragment();

            case 2:

                return new CompanyShow();
            case 3:
                return new ViewJobs();
            case 4:
                return new StudentViewApprovalFragment();


            default:
                return null;

        }


    }

    @Override
    public int getCount() {
        return 5;
    }
}
