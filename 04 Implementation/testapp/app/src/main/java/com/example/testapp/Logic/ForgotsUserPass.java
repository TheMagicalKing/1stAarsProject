package com.example.testapp.Logic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testapp.R;

/*Denne fil står for at give brugeren et nyt password hvis at brugeren
har glemt deres nuværende password*/

public class ForgotsUserPass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {              /*Nå der klikkes på
                                                                        "glemt password"
                                                                        Senders brugergen videre til
                                                                         Forgot_user_pass activity.
                                                                         */

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgots_user_pass);

        Button tester = findViewById(R.id.TestButton);
        tester.setOnClickListener(new View.OnClickListener() {      /* denne funktion ændre teksten.*/
            @Override
            public void onClick(View v) {

                EditText editText = findViewById(R.id.editTextTest);
                String test = String.valueOf(editText.getText());


            }
        });
    }



}
