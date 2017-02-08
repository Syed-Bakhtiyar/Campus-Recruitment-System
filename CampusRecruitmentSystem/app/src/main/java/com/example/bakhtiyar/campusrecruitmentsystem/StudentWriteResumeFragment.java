package com.example.bakhtiyar.campusrecruitmentsystem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
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
public class StudentWriteResumeFragment extends Fragment {

    int count = 0;



    EditText txt_fname, txt_lastname, txt_qualification, txt_lastyear, txt_skills, txt_experience;

    String name, last_name, qualification, lastyear, skills, experience;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    StudentInformation studentInformation;

    public StudentWriteResumeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_student_write_resume, container, false);


        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference().child("Students");

        func();


        txt_fname = (EditText) view.findViewById(R.id.firstname);

        txt_lastname = (EditText) view.findViewById(R.id.lastname);
        txt_qualification = (EditText) view.findViewById(R.id.qualification);

        txt_experience = (EditText) view.findViewById(R.id.experience);

        txt_lastyear = (EditText) view.findViewById(R.id.lastyear);

        txt_skills = (EditText) view.findViewById(R.id.skills);




        view.findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (count == 1) {

                    Toast.makeText(getContext(), "Sorry you have no right", Toast.LENGTH_SHORT).show();

                } else {

                    name = txt_fname.getText().toString();

                    last_name = txt_lastname.getText().toString();
                    qualification = txt_qualification.getText().toString();

                    lastyear = txt_lastyear.getText().toString();

                    experience = txt_experience.getText().toString();

                    skills = txt_skills.getText().toString();


                    if (TextUtils.isEmpty(name) ||
                            TextUtils.isEmpty(last_name) ||
                            TextUtils.isEmpty(qualification) ||
                            TextUtils.isEmpty(lastyear) ||
                            TextUtils.isEmpty(experience) ||

                            TextUtils.isEmpty(last_name)) {


                        Toast.makeText(getContext(), "please complete the form", Toast.LENGTH_SHORT).show();

                        return;
                    } else {

                        try {

                            studentInformation = new StudentInformation(name + " " + last_name, qualification, lastyear, skills, experience,StaticVariables.Uid);


                            databaseReference.child(studentInformation.getUid()).child("stud").setValue(studentInformation);

                            FirebaseDatabase.getInstance().getReference().child("publicStudents").child(studentInformation.getUid()).setValue(studentInformation);

                            txt_fname.setText("");

                            txt_experience.setText("");

                            txt_lastname.setText("");

                            txt_lastyear.setText("");

                            txt_qualification.setText("");

                            txt_skills.setText("");

                        }catch (Exception e){
                            Log.d("Bug", ""+e);

                        }



                    }


                }


            }
        });


        return view;
    }

    private void func() {


        databaseReference.child(StaticVariables.Uid).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                studentInformation = dataSnapshot.getValue(StudentInformation.class);

                if(studentInformation.getName()!="" || studentInformation.getName()!=null){


                    StaticVariables.studentInformation = studentInformation;

                    StaticVariables.count = 1;

                    count =1;

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
