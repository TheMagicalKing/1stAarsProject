package com.example.testapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.testapp.R;

// Denne fil kontrollere vores booking system.

public class BookingActivity extends AppCompatActivity {
    WebView bookingView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {  // Denne metode skaber en ny instans,
        // af vores embedde web browser og loader der efter bookingsystemets url.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        bookingView = findViewById(R.id.bookingView);
        if (savedInstanceState != null) {
            bookingView.restoreState(savedInstanceState);
        } else {
            bookingView.getSettings().setJavaScriptEnabled(true); // Denne if else statement tjekker om hvorhvidt
            // at savedInstanceState er falese. Hvis den ikker der det bliver der oprettede en række settings.
            bookingView.getSettings().setSupportZoom(true);
            bookingView.getSettings().setBuiltInZoomControls(false);
            bookingView.getSettings().setLoadWithOverviewMode(true);
            bookingView.getSettings().setUseWideViewPort(true);
            bookingView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            bookingView.setBackgroundColor(Color.WHITE);
            bookingView.setWebViewClient(new ourViewClient());
        }
        bookingView.loadUrl("https://system.easypractice.net/book/frederiksberg-sportsklinik#choose-service");
        //  her loades vores booking system.
    }
    public static class ourViewClient extends WebViewClient { // denne klasse står for cookie håndtering.
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            CookieManager.getInstance().setAcceptCookie(true);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }
}