package com.chromeinfotech.myfirst.UI.AvtivityExample;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;
import com.chromeinfotech.myfirst.R;
import com.chromeinfotech.myfirst.UI.Widgets.WebViewControl;
import com.chromeinfotech.myfirst.utils.Utils;

/**
 * customeActivity  to perform implicitintent
 */
public class customeActivity extends WebViewControl {
    private WebView webView=null;
    private String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custome);
        Utils.printLog(TAG  , "inside onCreate()");

        TextView label  = (TextView) findViewById(R.id.show_data);
        webView         = (WebView)  findViewById(R.id.webView);
        Uri url         = getIntent().getData();
        webView.loadUrl(String.valueOf(url));

        Utils.printLog(TAG  , "outside onCreate()");
    }
}
