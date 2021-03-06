package com.example.bakhtiyar.campusrecruitmentsystem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewAllStudents extends Fragment {

    View v;

    ListView listView;

    ArrayList<StudentInformation> arrayList;

    StudentProfileAdapter studentProfileAdapter;

    StudentInformation studentInformation;

    public ViewAllStudents() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_view_all_students, container, false);

        listView = (ListView) v.findViewById(R.id.list);

        arrayList = new ArrayList<>();

        studentProfileAdapter = new StudentProfileAdapter(arrayList,getContext(),2);

        listView.setAdapter(studentProfileAdapter);

        FirebaseDatabase.getInstance().getReference().child("publicStudents").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                studentInformation = dataSnapshot.getValue(StudentInformation.class);

                arrayList.add(studentInformation);

                studentProfileAdapter.notifyDataSetChanged();

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
