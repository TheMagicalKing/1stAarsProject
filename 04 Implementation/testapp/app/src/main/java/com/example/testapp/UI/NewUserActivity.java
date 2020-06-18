package com.example.testapp.UI;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.testapp.R;
import com.example.testapp.persistens.NewUserDBController;


public class NewUserActivity extends AppCompatActivity { // denne fil står for at oprette nye brugere.

   NewUserDBController newUserDBController = new NewUserDBController();


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
        final Intent intetToChange = new Intent(this, NewUserActivity.class);




        signUpKnap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // den funktion setter de forskellige indput felter og tager imod bruger indput.
                String email = userEmail.getText().toString().trim();
                String password = userPass.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    userEmail.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    userPass.setError("Password is Required");
                    return;
                }

                if (password.length() < 6) {
                    userPass.setError("Password must be >= 6 characters");
                    return;
                }
                // register the user in firebase
                newUserDBController.newUserFirebaseAdd(email, password, NewUserActivity.this,intetToChange);
            }
        });
    }



    private void forsideChange() { // går tilbage til forsiden.
        Intent intent = new Intent(this, ForsideActivity.class);
        startActivity(intent);
        }

    }

