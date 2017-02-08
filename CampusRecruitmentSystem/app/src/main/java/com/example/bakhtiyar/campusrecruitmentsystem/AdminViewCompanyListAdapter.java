package com.example.bakhtiyar.campusrecruitmentsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bakhtiyar on 2/2/2017.
 */
public class AdminViewCompanyListAdapter extends BaseAdapter {

    ArrayList<CompanyInformation> arrayList;

    Context context;

    LayoutInflater inflater;

    TextView comName, name, email, quali, exp;


    public AdminViewCompanyListAdapter(ArrayList<CompanyInformation> arrayList, Context context) {
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

        name.setVisibility(View.GONE);

        email.setVisibility(View.GONE);

        quali.setVisibility(View.GONE);

        exp.setVisibility(View.GONE);

        return view;

    }
}
