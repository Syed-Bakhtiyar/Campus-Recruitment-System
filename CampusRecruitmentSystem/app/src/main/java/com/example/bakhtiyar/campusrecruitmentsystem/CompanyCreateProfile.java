package com.example.bakhtiyar.campusrecruitmentsystem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyCreateProfile extends Fragment {


    int count =0;

    View v;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    EditText txt_name, txt_email;

    String name, email;

    CompanyInformation companyInformation;

    public CompanyCreateProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_company_create_profile, container, false);




        firebaseDatabase =  FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference().child("Company");

        func();

        txt_name = (EditText) v.findViewById(R.id.name);

        txt_email = (EditText) v.findViewById(R.id.email);

        v.findViewById(R.id.create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(count == 1){

                    Toast.makeText(getContext(), "Sorry you have to update your profile", Toast.LENGTH_SHORT).show();

                }
                else {
                    name = txt_name.getText().toString().trim();

                    email = txt_email.getText().toString().trim();


                    if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email)) {

                        Toast.makeText(getContext(), "Please insert complete", Toast.LENGTH_SHORT).show();

                        txt_name.setText("");

                        txt_email.setText("");


                        return;
                    } else {

                        companyInformation = new CompanyInformation(name, email,StaticVariables.Uid);

                        databaseReference.child(companyInformation.getUid()).child("Profile").setValue(companyInformation);

                        FirebaseDatabase.getInstance().getReference().child("PublicCompany").child(companyInformation.getUid()).setValue(companyInformation);


                        txt_name.setText("");

                        txt_email.setText("");

                    }


                }
            }
        });

        return v;
    }


    private void func(){


        databaseReference.child(StaticVariables.Uid).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                CompanyInformation companyInformation = dataSnapshot.getValue(CompanyInformation.class);

                if(companyInformation.getName() != null || companyInformation.getName() != ""){


                    count = 1;


                }

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



    }

}
