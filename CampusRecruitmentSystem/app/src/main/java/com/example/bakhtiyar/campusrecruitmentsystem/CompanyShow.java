package com.example.bakhtiyar.campusrecruitmentsystem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyShow extends Fragment {


    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    ListView listView;

    ArrayList<CompanyInformation> arrayList;

    ViewAllCompanyListAdapter viewAllCompanyListAdapter;

    View v;

    CompanyInformation companyInformation;

  //  FirebaseDatabase firebaseDatabase;

   // DatabaseReference databaseReference;

    public CompanyShow() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_company_show, container, false);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference().child("PublicCompany");

        listView = (ListView) v.findViewById(R.id.list);

        arrayList = new ArrayList<>();

        viewAllCompanyListAdapter = new ViewAllCompanyListAdapter(arrayList,getContext());


        listView.setAdapter(viewAllCompanyListAdapter);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                companyInformation = dataSnapshot.getValue(CompanyInformation.class);

                arrayList.add(companyInformation);

                viewAllCompanyListAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });









        return v;
    }

}
