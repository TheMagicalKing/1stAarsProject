package com.example.testapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.testapp.OevelseActivity;
import com.example.testapp.R;

public class BookingActivity extends AppCompatActivity {
    WebView bookingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        bookingView = (WebView) findViewById(R.id.bookingView);
        if (savedInstanceState != null) {
            bookingView.restoreState(savedInstanceState);
        } else {
            bookingView.getSettings().setJavaScriptEnabled(true);
            bookingView.getSettings().setSupportZoom(true);
            bookingView.getSettings().setBuiltInZoomControls(false);
            bookingView.getSettings().setLoadWithOverviewMode(true);
            bookingView.getSettings().setUseWideViewPort(true);
            bookingView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            bookingView.setBackgroundColor(Color.WHITE);
            bookingView.setWebViewClient(new ourViewClient());
        }
        bookingView.loadUrl("https://system.easypractice.net/book/frederiksberg-sportsklinik#choose-service");
    }
    public class ourViewClient extends WebViewClient {
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