package com.chromeinfotech.broadcasr_receiver.StaticRegisterReceiver;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.chromeinfotech.broadcasr_receiver.BaseActivity.BaseActivity;
import com.chromeinfotech.broadcasr_receiver.R;
import com.chromeinfotech.broadcasr_receiver.utils.Utils;

public class StaticRegisterActivity extends BaseActivity {

    private Button btnsongpause ,btnsongplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_register);
        this.reference();
        this.setListenrs();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void reference() {
        btnsongpause = (Button) findViewById(R.id.btnsongpause) ;
        btnsongplay = (Button) findViewById(R.id.btnsongplay) ;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Utils.showToast(this , "inside onDestroy()");
    }

    @Override
    public void setListenrs() {
        btnsongplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("message" , "song play");
                intent.setAction("mycustomeaction") ;
                sendBroadcast(intent);
            }
        });
        btnsongpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("message" , "song stop");
                intent.setAction("mycustomeaction") ;
                sendBroadcast(intent);
            }
        });
    }
}
