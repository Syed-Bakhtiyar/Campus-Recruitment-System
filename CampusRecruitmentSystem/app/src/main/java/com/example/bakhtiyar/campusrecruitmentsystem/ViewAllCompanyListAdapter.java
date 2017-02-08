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
public class ViewAllCompanyListAdapter extends BaseAdapter {

    ArrayList<CompanyInformation> arrayList;

    Context context;

    LayoutInflater inflater;

    TextView name, email;


    public ViewAllCompanyListAdapter(ArrayList<CompanyInformation> arrayList, Context context) {
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

        email = (TextView) view.findViewById(R.id.skills);

        view.findViewById(R.id.qualification).setVisibility(View.GONE);

        view.findViewById(R.id.experience).setVisibility(View.GONE);

        name.setTextSize(25);

        email.setTextSize(25);

        name.setText("Company Name: "+arrayList.get(i).getName());

        email.setText("Email Address is: "+arrayList.get(i).getEmail());


        return view;
    }
}
