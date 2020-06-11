package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.testapp.logic.forsideActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class newUserActivity extends AppCompatActivity {

    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);


        final Button signUpKnap = findViewById(R.id.signUpKnap);
        final EditText userEmail = findViewById(R.id.userEmail);
        final EditText userPass = findViewById(R.id.userPass);
        final EditText phoneNumber = findViewById(R.id.phoneNumber);
        final EditText forNavn = findViewById(R.id.forNavn);
        final EditText efterNavn = findViewById(R.id.efterNavn);



        fAuth = FirebaseAuth.getInstance();


        signUpKnap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = userEmail.getText().toString().trim();
                String password = userPass.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    userEmail.setError("Indtast Email");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    userPass.setError("Indtast Password");
                    return;
                }

                // register the user in firebase
                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(newUserActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                            forsideChange();
                        } else {
                            Toast.makeText(newUserActivity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }


    private void forsideChange() {
        Intent intent = new Intent(this, forsideActivity.class);
        startActivity(intent);
        }

    }

