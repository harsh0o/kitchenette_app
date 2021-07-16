package com.example.kitchenette;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class resetPassword extends AppCompatActivity {

    EditText userPassword,userConfirmPassword;
    Button savePassBtn;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        bottomNavigation();

        userPassword =findViewById(R.id.newUserPassword);
        userConfirmPassword = findViewById(R.id.newConfirmPass);

        user = FirebaseAuth.getInstance().getCurrentUser();

        savePassBtn = findViewById(R.id.resetPassBtn);
        savePassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userPassword.getText().toString().isEmpty())
                {
                    userPassword.setError("Required Field");
                    return;
                }
                if (userConfirmPassword.getText().toString().isEmpty()){
                    userConfirmPassword.setError("Required Field");
                    return;
                }

                if (!userPassword.getText().toString().equals(userConfirmPassword.getText().toString())){
                    userConfirmPassword.setError("password do not match");
                    return;
                }

                user.updatePassword(userPassword.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(resetPassword.this,"Password Updated",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),home.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(resetPassword.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    /*---------------s call bottom navBar------------*/
    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.card_btn);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(resetPassword.this, CartListActivity.class));
                finish();
            }
        });

        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(resetPassword.this, home.class));
                finish();
            }
        });

    }
    /*---------------e call bottom navBar------------*/
}