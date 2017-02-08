package com.example.bakhtiyar.campusrecruitmentsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Junaid on 1/27/2017.
 */

public class StudentProfileAdapter extends BaseAdapter {

    TextView name, lastyear, qualification, skills,experience;



    int a;


    ArrayList<StudentInformation> arrayList;
    Context context;
    LayoutInflater inflater;

    public StudentProfileAdapter(ArrayList<StudentInformation> arrayList,Context context, int a) {
        this.arrayList = arrayList;
        this.context = context;
        this.a = a;

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(a==1){
            view = inflater.from(context).inflate(R.layout.student_profile_layout,viewGroup,false);

            name = (TextView) view.findViewById(R.id.name);

            skills = (TextView) view.findViewById(R.id.skills );

            experience = (TextView) view.findViewById(R.id.experience);

            lastyear = (TextView) view.findViewById(R.id.lastyear);

            qualification = (TextView) view.findViewById(R.id.qualification);

            name.setText(arrayList.get(i).getName());

            skills.setText(arrayList.get(i).getSkills());

            experience.setText(arrayList.get(i).getExperience());

            lastyear.setText(arrayList.get(i).getLastyear());

            qualification.setText(arrayList.get(i).getQualification());


        }
        else if(a==2){
            view = inflater.from(context).inflate(R.layout.student_profile_layout,viewGroup,false);

            name = (TextView) view.findViewById(R.id.name);

            skills = (TextView) view.findViewById(R.id.skills );

            experience = (TextView) view.findViewById(R.id.experience);

            lastyear = (TextView) view.findViewById(R.id.lastyear);

            qualification = (TextView) view.findViewById(R.id.qualification);

            name.setText(arrayList.get(i).getName());

            skills.setText(arrayList.get(i).getSkills());

            experience.setText(arrayList.get(i).getExperience());

            lastyear.setText(arrayList.get(i).getLastyear());

            qualification.setText(arrayList.get(i).getQualification());


            lastyear.setVisibility(View.GONE);


            qualification.setVisibility(View.GONE);




        }
        else if(a==3){


            view = inflater.from(context).inflate(R.layout.student_profile_layout,viewGroup,false);

            name = (TextView) view.findViewById(R.id.name);

            skills = (TextView) view.findViewById(R.id.skills );

            experience = (TextView) view.findViewById(R.id.experience);

            lastyear = (TextView) view.findViewById(R.id.lastyear);

            qualification = (TextView) view.findViewById(R.id.qualification);

            name.setText(arrayList.get(i).getName());

            skills.setText(arrayList.get(i).getSkills());

            experience.setVisibility(View.GONE);


            lastyear.setVisibility(View.GONE);


            qualification.setVisibility(View.GONE);


        }

        return view;
    }
}
