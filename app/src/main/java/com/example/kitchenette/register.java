package com.example.kitchenette;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {

    Button button;
    EditText email,full_name,password,phone,passwordConfirm;
    Button regBtn;
    FirebaseAuth fAuth;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        button = findViewById(R.id.loginBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(register.this,login.class);
                startActivity(intent);
            }
        });

        email = findViewById(R.id.email);
        full_name = findViewById(R.id.full_name);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        passwordConfirm = findViewById(R.id.passwordConfirm);
        regBtn = findViewById(R.id.regBtn);

        fAuth = FirebaseAuth.getInstance();

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regfullname = full_name.getText().toString();
                String regemail = email.getText().toString();
                String regpass  = password.getText().toString();
                String regcnfpass   = passwordConfirm.getText().toString();


                if(regfullname.isEmpty()){
                    full_name.setError("Name is required");
                    return;
                }
                if(regemail.isEmpty()){
                    email.setError("Email is required");
                    return;
                }

                if(regpass.isEmpty()){
                    password.setError("Password is required");
                    return;
                }
                if(regcnfpass.isEmpty()){
                    passwordConfirm.setError("Confirm Password is required");
                    return;
                }
                if(!regpass.equals(regcnfpass)){
                    passwordConfirm.setError("Password  do no match");
                    return;
                }

                Toast.makeText(register.this,"You are Successfully Register",Toast.LENGTH_SHORT).show();

                //firebase register
                fAuth.createUserWithEmailAndPassword(regemail,regpass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        //insert user data into firebase

                        String uid = authResult.getUser().getUid();


                        Users user = new Users(uid,full_name.getText().toString(),email.getText().toString(),phone.getText().toString(),password.getText().toString(),0);



                        firebaseDatabase.getReference().child("Users").child(uid).setValue(user);



                        startActivity(new Intent(getApplicationContext(),login.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(register.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });


    }
}