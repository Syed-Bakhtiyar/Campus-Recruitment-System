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
public class CompanyListAdapter extends BaseAdapter {

    ArrayList<CompanyJobsRequirement> arrayList;

    Context context;

    LayoutInflater inflater;

    TextView comName, name, email, quali, exp;

    public CompanyListAdapter(ArrayList<CompanyJobsRequirement> arrayList, Context context) {
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

        view = inflater.from(context).inflate(R.layout.company_custom_list,viewGroup,false);


        name = (TextView) view.findViewById(R.id.job);

        comName = (TextView) view.findViewById(R.id.comName);

        email = (TextView) view.findViewById(R.id.skills);

        quali = (TextView) view.findViewById(R.id.qualification);

        exp = (TextView) view.findViewById(R.id.experience);

        comName.setText("Company Name is: "+arrayList.get(i).getName());

        name.setText("Job: "+arrayList.get(i).getJob());

        email.setText("Person Skills: "+arrayList.get(i).getSkills());

        quali.setText("Qualification: "+arrayList.get(i).getQualification());

        exp.setText("Experience: "+arrayList.get(i).getExperience());

        return view;
    }
}
