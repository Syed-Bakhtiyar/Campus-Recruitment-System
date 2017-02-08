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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyJobsPost extends Fragment {

    View v;

    EditText txt_job, txt_person_skills, txt_qual, txt_experience;

    String job, skills, qualification, experience;

    FirebaseAuth firebaseAuth;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    CompanyJobsRequirement companyJobsRequirement;

    public CompanyJobsPost() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_company_jobs_post, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference().child("CompanyJobs").child(StaticVariables.Uid);

        txt_job = (EditText) v.findViewById(R.id.job);
        txt_person_skills = (EditText) v.findViewById(R.id.person);
        txt_qual = (EditText) v.findViewById(R.id.qualification);
        txt_experience = (EditText) v.findViewById(R.id.Experince);

        v.findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                job = txt_job.getText().toString().trim();

                skills = txt_person_skills.getText().toString().trim();

                qualification = txt_qual.getText().toString().trim();

                experience = txt_experience.getText().toString().trim();

                if (TextUtils.isEmpty(job) ||
                        TextUtils.isEmpty(skills) ||
                        TextUtils.isEmpty(qualification) ||
                        TextUtils.isEmpty(experience)) {

                    Toast.makeText(getContext(), "Complete your form", Toast.LENGTH_SHORT).show();

                    txt_job.setText("");

                    txt_person_skills.setText("");

                    txt_qual.setText("");

                    txt_experience.setText("");

                    return;

                } else {

                    try {

                        companyJobsRequirement = new CompanyJobsRequirement(job, skills, qualification, experience, databaseReference.push().getKey().toString(), StaticVariables.companyInformation.getName(), StaticVariables.Uid);

                        databaseReference.child(companyJobsRequirement.getPushKey()).setValue(companyJobsRequirement);

                        FirebaseDatabase.getInstance().getReference().child("PublicJobs").child(companyJobsRequirement.getPushKey()).setValue(companyJobsRequirement);

                        Toast.makeText(getContext(), "Submitted", Toast.LENGTH_SHORT).show();

                        txt_job.setText("");

                        txt_person_skills.setText("");

                        txt_qual.setText("");

                        txt_experience.setText("");

                    } catch (Exception e) {

                        Log.d("gandu", "onClick: " + e);

                    }


                }


            }
        });


        return v;
    }

}
