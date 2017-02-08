package com.example.bakhtiyar.campusrecruitmentsystem;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Bakhtiyar on 1/28/2017.
 */
public class AdminFragmentPagerAdapter extends FragmentPagerAdapter {
    public AdminFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)  {
            case 0:

                return new AdminViewAllCompanies();

            case 1:

                return new AdminViewJobs();

            case 2:

                return new AdminViewStudents();



            default:
                return null;



        }



    }



    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position)

    {
        switch (position)  {
            case 0:

                return  "AdminViewAllCompanies";

            case 1:

                return "AdminViewJobs";

            case 2:

                return "AdminViewStudents";



            default:
                return null;



        }

    }
}
