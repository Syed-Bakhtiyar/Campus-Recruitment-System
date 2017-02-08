package com.example.bakhtiyar.campusrecruitmentsystem;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudentLogin extends Fragment {

    FirebaseAuth firebaseAuth;

    EditText txt_email,txt_password;

    String email,password;

    FirebaseAuth.AuthStateListener fiAuthStateListener;

    View view;

    public StudentLogin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_student_login, container, false);

        firebaseAuth = FirebaseAuth.getInstance();
//
//        fiAuthStateListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//
//                if(user!=null){
//
//                    StaticVariables.Uid = user.getUid();
//
//                    startActivity(new Intent(getActivity(),StudentActivity.class));
//
//                    // todo something
//
//                }
//
//
//            }
//        };

        txt_email = (EditText) view.findViewById(R.id.email);

        txt_password = (EditText) view.findViewById(R.id.password);

        view.findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = txt_email.getText().toString().trim();

                password = txt_password.getText().toString().trim();

                if(TextUtils.isEmpty(email)|| TextUtils.isEmpty(password)){

                    txt_email.setText("");

                    txt_password.setText("");

                    Toast.makeText(getContext(), "Please Insert form", Toast.LENGTH_SHORT).show();

                    return;

                }else {

                    firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){

                                Toast.makeText(getContext(), "Successfull", Toast.LENGTH_SHORT).show();
                                StaticVariables.Uid = firebaseAuth.getCurrentUser().getUid();
                                startActivity(new Intent(getActivity(),StudentActivity.class));
                            }

                        }
                    });


                }



            }
        });


        view.findViewById(R.id.create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),CreateUser.class));
            }
        });


        return view;
    }

}
