package com.example.bakhtiyar.campusrecruitmentsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bakhtiyar on 1/28/2017.
 */
public class DoneListAdapter extends BaseAdapter {

    ArrayList<ApplyVacancy> arrayList;

    Context context;

    LayoutInflater inflater;

    TextView name, experience,lastyear,qualification,skills;

    public DoneListAdapter(ArrayList<ApplyVacancy> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
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

        view = inflater.from(context).inflate(R.layout.student_profile_layout,viewGroup,false);

        name = (TextView) view.findViewById(R.id.name);

        experience = (TextView) view.findViewById(R.id.experience);

        lastyear = (TextView) view.findViewById(R.id.lastyear);

        qualification = (TextView) view.findViewById(R.id.qualification);

        skills = (TextView) view.findViewById(R.id.skills);

        name.setText("Name: "+arrayList.get(i).getName());
        name.setText("Experience: "+arrayList.get(i).getExperience());
        name.setText("Last Year: "+arrayList.get(i).getLastyear());
        name.setText("Qualification: "+arrayList.get(i).getQualification());
        name.setText("Skills : "+arrayList.get(i).getSkills());

        return view;
    }
}
