package com.chromeinfotech.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.chromeinfotech.BaseActivity.BaseActivity;
import com.chromeinfotech.androidstorage.InternalStorage.ChoosePictureActivity;
import com.chromeinfotech.androidstorage.InternalStorage.InternalStorageActivity;
import com.chromeinfotech.androidstorage.SharedPreferences.MainActivity;
import com.chromeinfotech.androidstorage.R;
import com.chromeinfotech.androidstorage.SharedPreferences.SharePreferencewithlist;

public class Main2Activity extends BaseActivity implements View.OnClickListener {
    private Button btnstoteobject, btnstorelist , btninternalstorage ,btnchooseimage,btnExternalStorage ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.reference();
        this.setListenrs();
    }

    @Override
    public void reference() {
        btnstoteobject                     = (Button) findViewById(R.id.btnstoteobject);
        btnstorelist                       = (Button) findViewById(R.id.btnstorelist);
        btninternalstorage                 = (Button) findViewById(R.id.btninternalstorage);
        btnchooseimage                     = (Button) findViewById(R.id.btnchooseimage);
        btnExternalStorage                 =(Button)  findViewById(R.id.btn_ExternalStorage);
    }

    @Override
    public void setListenrs() {
        btnstoteobject.setOnClickListener(this);
        btnstorelist.setOnClickListener(this);
        btninternalstorage.setOnClickListener(this);
        btnchooseimage.setOnClickListener(this);
        btnExternalStorage.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnstoteobject:
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btnstorelist:
                Intent intent1 = new Intent(Main2Activity.this, SharePreferencewithlist.class);
                startActivity(intent1);
                break;
            case R.id.btninternalstorage:
                Intent intent3 = new Intent(Main2Activity.this, InternalStorageActivity.class);
                startActivity(intent3);
                break;
            case R.id.btnchooseimage:
                Intent intent4 = new Intent(Main2Activity.this, ChoosePictureActivity.class);
                startActivity(intent4);
            case R.id.btn_ExternalStorage:
                Intent intent5 = new Intent(Main2Activity.this, ExternalActivity.class);
                startActivity(intent5);
                break;
        }
    }
}
