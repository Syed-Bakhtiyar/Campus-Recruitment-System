package com.example.bakhtiyar.campusrecruitmentsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bakhtiyar on 1/31/2017.
 */
public class ViewVacancyAdapter extends BaseAdapter {

    ArrayList<DoneVacanciesClass> arrayList;

    LayoutInflater inflater;

    Context context;

    TextView txt1, txt2, txt3;

    public ViewVacancyAdapter(ArrayList<DoneVacanciesClass> arrayList, Context context) {
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

        view  =   inflater.from(context).inflate(R.layout.company_view,viewGroup,false);


        txt1 = (TextView) view.findViewById(R.id.inerview);

        txt2 = (TextView) view.findViewById(R.id.date);

        txt3 = (TextView) view.findViewById(R.id.name);

        txt1.setText(arrayList.get(i).getInterview());

        txt2.setText(arrayList.get(i).date);

        txt3.setText(arrayList.get(i).getPushkey());

        return view;
    }
}
