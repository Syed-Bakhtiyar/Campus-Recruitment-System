package com.example.bakhtiyar.campusrecruitmentsystem;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Bakhtiyar on 1/28/2017.
 */
public class CampusFragmentAdapter extends FragmentPagerAdapter {
    public CampusFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){

            case 0:

                return new CompanyCreateProfile();

            case 1:

                return new ViewCompanyProfile();

            case 2:

                return new CompanyJobsPost();

            case 3:

                return new ViewCompanyJobs();
            case 4:

                return new ViewAllStudents();

            case 5:

                return new CompanyViewVacancies();

            default:

                return null;
        }
    }

    @Override
    public int getCount() {
        return 6;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){

            case 0:

                return "Create New Profile";

            case 1:

                return "View Profile";

            case 2:

                return "Jobs post";

            case 3:

                return "View your jobs";
            case 4:


                return "View Students";

            case 5:

                return "Company View Vacancy";
            default:

                return null;
        }
    }
}
