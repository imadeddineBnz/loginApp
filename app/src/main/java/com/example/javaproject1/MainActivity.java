package com.example.javaproject1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth;
    Button button;
    TextView textView;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();
        button=findViewById(R.id.btn_logout);
        textView=findViewById(R.id.textView);
        user= auth.getCurrentUser();
        if (user==null){
            Intent intent= new Intent(getApplicationContext(), log.class);
            startActivity(intent);
            finish();
        }else {
            try {
                textView.setText(user.getEmail());
            }catch(Exception ex ){
                Toast.makeText( getApplicationContext() , ex.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent= new Intent(getApplicationContext(), log.class);
                startActivity(intent);
                finish();

            }
        });
    }

    }


