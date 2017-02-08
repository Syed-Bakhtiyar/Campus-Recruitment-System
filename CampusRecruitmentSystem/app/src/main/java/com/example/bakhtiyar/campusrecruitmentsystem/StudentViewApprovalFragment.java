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
public class StudentViewApprovalFragment extends Fragment {

    View v;

    ListView listView;

    ArrayList<DoneVacanciesClass> arrayList;

    ViewVacancyAdapter viewVacancyAdapter;

    DoneVacanciesClass doneVacanciesClass;

    public StudentViewApprovalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_student_view_approval, container, false);

        listView = (ListView) v.findViewById(R.id.list);

        arrayList = new ArrayList<>();

        viewVacancyAdapter = new ViewVacancyAdapter(arrayList,getContext());

        listView.setAdapter(viewVacancyAdapter);

        FirebaseDatabase.getInstance().getReference().child("DoneJobs").child(StaticVariables.Uid).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                doneVacanciesClass = dataSnapshot.getValue(DoneVacanciesClass.class);

                arrayList.add(doneVacanciesClass);

                Log.d("hh", "onChildAdded: ");

                viewVacancyAdapter.notifyDataSetChanged();



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
