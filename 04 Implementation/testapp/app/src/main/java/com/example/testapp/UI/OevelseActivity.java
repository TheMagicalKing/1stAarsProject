package com.example.testapp.UI;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.testapp.R;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;

// Denne fil viser brugerenes øvelser.

public class OevelseActivity extends AppCompatActivity {
    private WebView webView;
    ProgressBar progressBar;
    EditText editText;
    Button button;
    private int position;
    private ArrayList<String> oevelseList;
    private String oevelseName;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // denn metode hender og viser brugeren øvelser.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oevelse);

        validateReceiveValues();

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressBar.setVisibility(View.GONE);
        webView = (WebView) findViewById(R.id.webView);
        if (savedInstanceState != null) {
            webView.restoreState(savedInstanceState);
        } else {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setSupportZoom(true);
            webView.getSettings().setBuiltInZoomControls(false);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            webView.setBackgroundColor(Color.WHITE);
            webView.setWebViewClient(new ourViewClient());
            webView.setWebChromeClient(new WebChromeClient() {
                @Override
                public void onProgressChanged(WebView view, int progress) {
                    super.onProgressChanged(view, progress);
                    if (progress < 100 && progressBar.getVisibility() == ProgressBar.GONE) {
                        progressBar.setVisibility(ProgressBar.VISIBLE);
                    }
                    if (progress == 100) {
                        progressBar.setVisibility(ProgressBar.GONE);
                    }
                }
            });
        }

    }

    // de følgende metoder styre cookis, og skaber sætter ting ind i list viewet.
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        webView.saveState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.web_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { // Denne funktion indeholder en kontrole statement der sstyre hvad der sker når at brugeren ville ha vist en video.
        switch (item.getItemId()) {
            case R.id.item_back:
                if (webView.canGoBack()) {
                    webView.goBack();
                }
                return true;
            case R.id.item_forward:
                if (webView.canGoForward()) {
                    webView.goForward();
                }
                return true;
            case R.id.item_home:
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                webView.loadUrl("https://google.com");

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void validateReceiveValues() {
        webView = (WebView) findViewById(R.id.webView);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        String data = b.getString("a");
        webView.loadUrl("https://" + data);
    }
}
