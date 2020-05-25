package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testapp.R;

public class forsideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forside);

        final Button chatButton = findViewById(R.id.chatButton);
        final Button oevelseButon = findViewById(R.id.oevelserButton);
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChat();
            }
        });
        oevelseButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOevelse();
            }
        });
    }

    private void openChat() {

        Intent intent = new Intent(this, klientChat.class);
        startActivity(intent);

    }

    private void openOevelse() {

        Intent intent = new Intent(this, oevelseActivity.class);
        startActivity(intent);

    }
}
