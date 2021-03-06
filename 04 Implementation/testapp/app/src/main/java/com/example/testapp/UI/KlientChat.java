package com.example.testapp.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testapp.R;


public class KlientChat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klient_chat);

        final ImageView backImage = findViewById(R.id.backImage);

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForside();
            }
        });
    }
    private void openForside(){
        Intent intent = new Intent(this, ForsideActivity.class);
        startActivity(intent);
    }
}
