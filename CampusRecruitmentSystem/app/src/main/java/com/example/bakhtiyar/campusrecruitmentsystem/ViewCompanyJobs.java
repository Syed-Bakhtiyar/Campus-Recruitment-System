package com.example.bakhtiyar.campusrecruitmentsystem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewCompanyJobs extends Fragment {

    View v;

    ListView listView;

    CompanyJobsRequirement companyJobsRequirement;

    ArrayList<CompanyJobsRequirement> arrayList;

    CompanyListAdapter companyListAdapter;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;



    public ViewCompanyJobs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_view_company_jobs, container, false);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference().child("CompanyJobs").child(StaticVariables.Uid);


        listView = (ListView) v.findViewById(R.id.list);

        arrayList = new ArrayList<>();

        companyListAdapter = new CompanyListAdapter(arrayList,getContext());

        listView.setAdapter(companyListAdapter);



        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                companyJobsRequirement = dataSnapshot.getValue(CompanyJobsRequirement.class);

                arrayList.add(companyJobsRequirement);

                companyListAdapter.notifyDataSetChanged();
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
