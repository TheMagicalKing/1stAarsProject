package com.example.testapp.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testapp.Logic.OevelseListActivity;
import com.example.testapp.R;

public class ForsideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forside);

        final Button chatButton = findViewById(R.id.chatButton);
        final Button oevelseButon = findViewById(R.id.oevelserButton);
        final Button bookingButton = findViewById(R.id.bookingButton);
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
        bookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBooking();
            }
        });
    }

    private void openChat() {

        Intent intent = new Intent(this, KlientChat.class);
        startActivity(intent);

    }

    private void openOevelse() {

        Intent intent = new Intent(this, Test.class);
        startActivity(intent);

    }

    private void openBooking() {
        Intent intent = new Intent(this, BookingActivity.class);
        startActivity(intent);
    }
}
