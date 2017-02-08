package com.example.bakhtiyar.campusrecruitmentsystem;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static java.security.AccessController.getContext;

/**
 * Created by Junaid on 1/28/2017.
 */

public class CreateCompany extends AppCompatActivity{

    FirebaseAuth firebaseAuth;

    EditText txt_email,txt_password;

    String email,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_company);

        firebaseAuth = FirebaseAuth.getInstance();

        txt_email = (EditText) findViewById(R.id.email);

        txt_password = (EditText) findViewById(R.id.password);

        findViewById(R.id.Signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = txt_email.getText().toString().trim();

                password = txt_password.getText().toString().trim();

                if(TextUtils.isEmpty(email)|| TextUtils.isEmpty(password)){

                    txt_email.setText("");

                    txt_password.setText("");

                    Toast.makeText(CreateCompany.this, "Please Insert form", Toast.LENGTH_SHORT).show();

                    return;

                }else {

                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){

                                Toast.makeText(CreateCompany.this, "Successfull", Toast.LENGTH_SHORT).show();
                              //  startActivity(new Intent(getActivity(),StudentActivity.class));

                            }
                        }
                    });
                }
            }
        });
    }
}
