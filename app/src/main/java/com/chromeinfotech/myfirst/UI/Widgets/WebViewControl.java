package com.chromeinfotech.myfirst.UI.Widgets;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

import com.chromeinfotech.myfirst.UI.BaseActivity.BaseActivity;
import com.chromeinfotech.myfirst.R;
import com.chromeinfotech.myfirst.utils.Utils;

public class WebViewControl extends BaseActivity {
    private WebView webView=null;
    private Button button ;
    private ProgressBar progressBar = null;
    private String TAG = this.getClass().getSimpleName();
    private String url="https://developer.android.com/reference/android/webkit/WebView.html";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_control);
        Utils.printLog(TAG  , "inside onCreate()");
        this.reference();
        this.setListenrs();
        Utils.printLog(TAG  , "outside onCreate()");
    }
    @Override
    public void reference() {
        Utils.printLog(TAG  , "inside reference()");
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        webView     = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new myWebClient());
        //webView.loadUrl(url);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String customHtml = "<html><body>Video From YouTube<br><iframe width=\"420\" height=\"315\" src=\"https://www.youtube.com/embed/47yJ2XCRLZs\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
        webView.loadData(customHtml, "text/html", "UTF-8");
        Utils.printLog(TAG  , "outside reference()");
    }
    @Override
    public void setListenrs() {
        Utils.printLog(TAG  , "inside setListenrs()");
        Utils.printLog(TAG  , "outside setListenrs()");
    }

    private class myWebClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view , String url , Bitmap favicon) {
            super.onPageStarted(view , url, favicon);
            Utils.printLog(TAG  , "inside onPageStarted()");
            progressBar.setVisibility(view.VISIBLE);
            Utils.printLog(TAG  , "outside onPageStarted()");
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            Utils.printLog(TAG  , "inside onPageFinished()");
            super.onPageFinished(view , url);
            progressBar.setVisibility(view.GONE);
            Utils.printLog(TAG  , "outside onPageFinished()");
        }
    }
    @Override
    public void onBackPressed() {
        Utils.printLog(TAG  , "inside onBackPressed()");
        if (webView.canGoBack()) {
            webView.goBack();
            return;
        }
        else
            super.onBackPressed();
        Utils.printLog(TAG  , "outside onBackPressed()");
    }
}

