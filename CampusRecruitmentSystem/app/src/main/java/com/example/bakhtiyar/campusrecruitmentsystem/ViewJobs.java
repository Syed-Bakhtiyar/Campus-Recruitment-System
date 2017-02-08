package com.example.bakhtiyar.campusrecruitmentsystem;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewJobs extends Fragment {

    ArrayList<CompanyJobsRequirement> arrayList;

    CompanyListAdapter companyListAdapter;

    ListView listView;

    View v;

    AlertDialog.Builder alert;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;


    public ViewJobs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_view_jobs, container, false);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference();

        listView = (ListView) v.findViewById(R.id.list);

        int aaa=0;

        arrayList = new ArrayList<>();

        companyListAdapter = new CompanyListAdapter(arrayList,getContext());


        listView.setAdapter(companyListAdapter);

        alert = new AlertDialog.Builder(getContext());


        databaseReference.child("PublicJobs").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                CompanyJobsRequirement companyJobsRequirement = dataSnapshot.getValue(CompanyJobsRequirement.class);

                Log.d("data", "onChildAdded: "+companyJobsRequirement.getJob());

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


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final int temp = i;

                try {




                    alert.setPositiveButton("You wan't to submit your vacancy?", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                            Date date = new Date();

                            String dttm =dateFormat.format(date);

//                            FirebaseDatabase.getInstance().getReference().child("ApplyJobs").child(StaticVariables.Uid).push().getKey()
                            ApplyVacancy applyVacancy = new ApplyVacancy(StaticVariables.studentInformation.getName(),StaticVariables.studentInformation.getQualification(),StaticVariables.studentInformation.getLastyear(),StaticVariables.studentInformation.getSkills(),StaticVariables.studentInformation.getExperience(),dttm,StaticVariables.Uid,FirebaseDatabase.getInstance().getReference().child("ApplyJobs").child(StaticVariables.Uid).push().getKey());

                            FirebaseDatabase.getInstance().getReference().child("ApplyJobs").child(arrayList.get(temp).getUid()).child(StaticVariables.Uid).setValue(applyVacancy);

                            Toast.makeText(getContext(), "Your Vacancy is submitted", Toast.LENGTH_SHORT).show();

                            return;

                        }
                    });

                    alert.show();





                }catch (Exception e){

                    Log.d("bug", "onItemClick: "+e);

                }

            }
        });










        return v;
    }

}
