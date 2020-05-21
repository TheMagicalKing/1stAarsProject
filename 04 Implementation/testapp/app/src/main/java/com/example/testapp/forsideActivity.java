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
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChat();
            }
        });

    }

    private void openChat(){

        Intent intent = new Intent(this, com.example.android.uitest.klientChat.class);
        startActivity(intent);

    }

    private void openOevelse(){

        Intent intent = new Intent(this, com.example.android.uitest.oevelseActivity.class);
        startActivity(intent);

    }
}
