package com.chromeinfotech.broadcasr_receiver.BroadcastType.OrderedBroadcast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.chromeinfotech.broadcasr_receiver.BaseActivity.BaseActivity;
import com.chromeinfotech.broadcasr_receiver.R;

public class OrderebroadcastActivitiy extends BaseActivity {
    private Button btnlaunch ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordered_broadcast_activiti);
        this.reference();
        this.setListenrs();
    }
    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void reference() {
btnlaunch = (Button) findViewById(R.id.btnlaunch) ;

    }

    @Override
    public void setListenrs() {
btnlaunch.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("Messsage" , "Launch");
        intent.setAction("orderedBroadcast") ;
        sendOrderedBroadcast(intent ,null);

    }
});
    }
}
