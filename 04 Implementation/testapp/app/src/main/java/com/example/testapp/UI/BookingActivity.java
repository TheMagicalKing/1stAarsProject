package com.example.testapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.testapp.R;

public class BookingActivity extends AppCompatActivity {
    WebView bookingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        bookingView = (WebView) findViewById(R.id.bookingView);
        bookingView.loadUrl("https://system.easypractice.net/book/frederiksberg-sportsklinik#choose-service");
    }
}