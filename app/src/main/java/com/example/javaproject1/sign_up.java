package com.example.javaproject1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class sign_up extends AppCompatActivity {

    TextInputEditText editTextEmail,editTextPassword;
    Button buttonReg;
    FirebaseAuth auth;
    ProgressBar progressBar;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        textView=findViewById(R.id.login_tv);
        auth=FirebaseAuth.getInstance();
        editTextEmail= findViewById(R.id.email);
        editTextPassword=findViewById(R.id.password);
        progressBar=findViewById(R.id.progressBar);
        buttonReg=findViewById(R.id.btn_signUp);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), log.class);
                startActivity(intent);
                finish();
            }
        });
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createUserWithEmailAndPassword(editTextEmail.getText().toString(),editTextPassword.getText().toString());



            }
        });
    }

    public void createUserWithEmailAndPassword(String email , String password){
        if (email.isEmpty()){
            //Toast.makeText(sign_up.this,"enter email",Toast.LENGTH_SHORT).show();
            editTextEmail.setError("Email Is Empty");
            return;
        }
        else if (password.isEmpty()){
            //Toast.makeText(sign_up.this,"enter password",Toast.LENGTH_SHORT).show();
            editTextPassword.setError("Password Is Empty");
            return;
        }else {
            progressBar.setVisibility(View.VISIBLE);

        auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(sign_up.this,"authentication complete",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(getApplicationContext(), log.class);
                startActivity(intent);
                progressBar.setVisibility(View.GONE);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(sign_up.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }}


}