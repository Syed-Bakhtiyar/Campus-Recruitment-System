package com.example.bakhtiyar.campusrecruitmentsystem;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdminViewAllStudentsApply extends Fragment {

    ArrayList<ApplyVacancy> arrayList;

    DoneListAdapter doneListAdapter;

    ListView listView;

    View v;

    AlertDialog.Builder alert;


    public AdminViewAllStudentsApply() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        v = inflater.inflate(R.layout.fragment_admin_view_student, container, false);



        listView = (ListView) v.findViewById(R.id.list);


        alert = new AlertDialog.Builder(getContext());

        arrayList = new ArrayList<>();

        doneListAdapter = new DoneListAdapter(arrayList,getContext());


        listView.setAdapter(doneListAdapter);

        FirebaseDatabase.getInstance().getReference().child("ApplyJobs").child(StaticVariables.Uid).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                ApplyVacancy applyVacancy = dataSnapshot.getValue(ApplyVacancy.class);

                arrayList.add(applyVacancy);

                doneListAdapter.notifyDataSetChanged();

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


                final int temp =i;



                alert.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        FirebaseDatabase.getInstance().getReference().child("ApplyJobs").child(arrayList.get(temp).getUuid()).child(arrayList.get(temp).getKey()).removeValue();



                        return;

                    }
                });

                alert.show();






            }
        });















        return v;
    }

}
