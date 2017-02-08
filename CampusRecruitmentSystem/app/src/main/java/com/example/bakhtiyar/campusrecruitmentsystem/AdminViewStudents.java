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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdminViewStudents extends Fragment {

    AlertDialog.Builder alert;

    View v;

    ListView listView;

    ArrayList<StudentInformation> arrayList;

    StudentProfileAdapter studentProfileAdapter;

    StudentInformation studentInformation;



    public AdminViewStudents() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_admin_view_students, container, false);

        alert = new AlertDialog.Builder(getContext());

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




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int temp =i;


                alert.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        FirebaseDatabase.getInstance().getReference().child("Students").child(arrayList.get(temp).getUid()).removeValue();

                        FirebaseDatabase.getInstance().getReference().child("publicStudents").child(arrayList.get(temp).getUid()).removeValue();

                        arrayList.remove(temp);

                        studentProfileAdapter.notifyDataSetChanged();

                        Toast.makeText(getContext(), "Deleted", Toast.LENGTH_SHORT).show();

                        return;

                    }
                });


                alert.show();

            }
        });



        return v;
    }

}
