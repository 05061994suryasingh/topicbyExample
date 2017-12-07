package com.chromeinfotech.myfirst.UI.Widgets;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.chromeinfotech.myfirst.UI.BaseActivity.BaseActivity;
import com.chromeinfotech.myfirst.R;
import com.chromeinfotech.myfirst.utils.Utils;

public class RadioButtonControl extends BaseActivity {
    private RadioGroup radioGroup ;
    private RadioButton radiobutton1 ;
    private Button Display ;
    private String TAG = this.getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        Utils.printLog(TAG  , "inside onCreate()");
        this.reference();
        this.setListenrs();
        Utils.printLog(TAG  , "outside onCreate()");
    }

    @Override
    public void reference() {
        Utils.printLog(TAG  , "inside reference()");
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        Display    = (Button) findViewById(R.id.Display);
        Utils.printLog(TAG  , "outside reference()");
    }

    @Override
    public void setListenrs() {
        Utils.printLog(TAG  , "inside setListenrs()");
        Display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get selected radio button from radioGroup
                int selectedItem=radioGroup.getCheckedRadioButtonId();
                if(selectedItem>0) {
                    radiobutton1 = (RadioButton) findViewById(selectedItem);
                    Toast.makeText(RadioButtonControl.this, radiobutton1.getText(), Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(RadioButtonControl.this,"no option is selected plz select one of them", Toast.LENGTH_SHORT).show();
            }
        });
        Utils.printLog(TAG  , "outside setListenrs()");
    }
}
