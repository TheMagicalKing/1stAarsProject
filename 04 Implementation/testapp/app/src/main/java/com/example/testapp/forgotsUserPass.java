package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.testapp.R;

public class forgotsUserPass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgots_user_pass);

        System.out.println("you're in");

        Button tester = findViewById(R.id.TestButton);
        tester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView hey = findViewById(R.id.testViewer);
                EditText editText = findViewById(R.id.editTextTest);
                String test = String.valueOf(editText.getText());
                hey.setText(test);

            }
        });
    }



}
