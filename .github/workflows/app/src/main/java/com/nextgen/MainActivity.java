package com.nextgen;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    // 1. Set your website URL here
    private static final String WEBVIEW_URL = "https://nextgenbywala.github.io/NA-/Nextgen.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create a new WebView object
        WebView webView = new WebView(this);
        
        // Set the layout to the WebView
        setContentView(webView);

        // 2. Configure WebView settings for modern web content
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true); 
        webSettings.setAllowContentAccess(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);

        // 3. Keep the user inside the app when clicking links
        webView.setWebViewClient(new WebViewClient() {
            // This method forces links to open inside the app's WebView
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true; 
            }
        });

        // 4. Load the specified URL
        webView.loadUrl(WEBVIEW_URL);
    }
    
    // 5. Handle back button presses (goes back in history instead of exiting app)
    @Override
    public void onBackPressed() {
        WebView webView = (WebView) findViewById(android.R.id.content).getRootView();
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
