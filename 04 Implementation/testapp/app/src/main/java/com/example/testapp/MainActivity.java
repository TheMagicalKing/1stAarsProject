package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.testapp.logic.forsideActivity;
import com.example.testapp.persistens.FireBaseController;
import com.example.testapp.ui.forgotsUserPass;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


public class  MainActivity extends AppCompatActivity {

    FireBaseController fireBaseController = new FireBaseController();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar3);

        final EditText userEmail = findViewById(R.id.userEmail);
        final EditText userPass = findViewById(R.id.userPass);
        final Button LogInKnap = findViewById(R.id.logInKnap);
        final Intent intentToChange = new Intent(this, forsideActivity.class);








        //sørger for Textviewet kan klikkes og sende brugeren videre til en glemt tlf, e-mail eller password.
        TextView forgotUserPass = findViewById(R.id.forgotsUserPass2);
        String forgotText = "Klik her!";
        SpannableString forgotSpan = new SpannableString(forgotText);
        ClickableSpan forgotClickSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                openForgot();
            }
        };
        forgotSpan.setSpan(forgotClickSpan,0,9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        forgotUserPass.setText(forgotSpan);
        forgotUserPass.setMovementMethod(LinkMovementMethod.getInstance());

        //Sørger for Textviewet kan klikkes og sende brugeren videre til noget sign-up
        TextView newUserFront = findViewById(R.id.nyBruger);
        String newUserText = "Ny hos klinikken? Opret en bruger her!";
        SpannableString newUserSpan = new SpannableString(newUserText);
        ClickableSpan newUserClickSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                openNewUser();
            }
        };
        newUserSpan.setSpan(newUserClickSpan,18,38, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        newUserFront.setText(newUserSpan);
        newUserFront.setMovementMethod(LinkMovementMethod.getInstance());


        LogInKnap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                //progressBar.setVisibility(View.VISIBLE);
                // authenticating user

                fireBaseController.MainFirebaseLogin(email, password, MainActivity.this, intentToChange);
            }
        });





        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }
    public void openForgot(){
        Intent intent = new Intent(this, forgotsUserPass.class);
        startActivity(intent);
    }

    public void openNewUser(){
        Intent intent = new Intent(this, newUserActivity.class);
        startActivity(intent);
    }

    public void openLogInd(){
        Intent intent = new Intent(this, forsideActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}