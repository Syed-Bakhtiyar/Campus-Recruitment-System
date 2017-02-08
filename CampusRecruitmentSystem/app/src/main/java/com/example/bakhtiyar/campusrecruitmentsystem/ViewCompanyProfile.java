package com.example.bakhtiyar.campusrecruitmentsystem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewCompanyProfile extends Fragment {

    View v;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    TextView name, email;




    public ViewCompanyProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v  = inflater.inflate(R.layout.fragment_view_company_profile, container, false);


        name = (TextView) v.findViewById(R.id.name);

        email = (TextView) v.findViewById(R.id.email);

        firebaseDatabase =  FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference().child("Company");


        databaseReference.child(StaticVariables.Uid).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                CompanyInformation companyInformation = dataSnapshot.getValue(CompanyInformation.class);

                StaticVariables.companyInformation = companyInformation;


                name.setText("Name: "+companyInformation.getName());

                email.setText("Email Address: "+companyInformation.getEmail());


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
