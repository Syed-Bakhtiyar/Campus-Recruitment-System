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
public class AdminViewJobs extends Fragment {

    ArrayList<CompanyJobsRequirement> arrayList;

    CompanyListAdapter companyListAdapter;

    ListView listView;

    View v;

    AlertDialog.Builder alert;

    public AdminViewJobs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v =  inflater.inflate(R.layout.fragment_admin_view_jobs, container, false);
        arrayList = new ArrayList<>();

        alert = new AlertDialog.Builder(getContext());

        companyListAdapter = new CompanyListAdapter(arrayList,getContext());

        listView = (ListView) v.findViewById(R.id.list);

        listView.setAdapter(companyListAdapter);

        FirebaseDatabase.getInstance().getReference().child("PublicJobs").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                CompanyJobsRequirement companyJobsRequirement = dataSnapshot.getValue(CompanyJobsRequirement.class);

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

                alert.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        FirebaseDatabase.getInstance().getReference().child("PublicJobs").child(arrayList.get(temp).getPushKey()).removeValue();

                        FirebaseDatabase.getInstance().getReference().child("CompanyJobs").child(arrayList.get(temp).getUid()).child(arrayList.get(temp).getPushKey()).removeValue();
                        
                        arrayList.remove(temp);

                        companyListAdapter.notifyDataSetChanged();

                        Toast.makeText(getContext(), "Deleted", Toast.LENGTH_SHORT).show();

                    }
                });

                alert.show();

            }
        });


        return v;
    }

}
