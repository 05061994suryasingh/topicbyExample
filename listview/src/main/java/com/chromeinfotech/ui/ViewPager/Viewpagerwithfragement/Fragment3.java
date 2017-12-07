package com.chromeinfotech.ui.ViewPager.Viewpagerwithfragement;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.chromeinfotech.listview.R;
import com.chromeinfotech.utils.Utils;

/**
 *show the second fragment textviewdata of first fragment in textview
 */

public class Fragment3 extends Fragment {

    private  TextView txttab3 ;
    private EditText etxtab3 ;
    private  Button btnclick3;
    private FragementCommunication listner;
    private String TAG = this.getClass().getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        Utils.printLog(TAG,"inside onCreateView");
        View view = inflater.inflate(R.layout.tab3, container, false); //inflate tab3 layout
        this.reference(view);
        this.setListner();
        Utils.printLog(TAG,"outside onCreateView");

        return view;
    }

    /**
     * create the reference
     * @param view
     */
    private void reference(View view) {
        Utils.printLog(TAG,"inside reference");
        txttab3   = (TextView) view.findViewById(R.id.txttab3);
        etxtab3 = (EditText) view.findViewById(R.id.etxtab3);
        btnclick3 = (Button)   view.findViewById(R.id.btnclick3);
        Utils.printLog(TAG,"outside reference");
    }

    /**
     * set the listner
     */
    private void setListner() {
        Utils.printLog(TAG,"inside setListner");
        btnclick3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  data = etxtab3.getText().toString();
                listner.onItemSelected(data);
            }
        });
        Utils.printLog(TAG,"outside setListner");
    }

    public Fragment3() {

    }

    /**
     * set thext to textview
     * @param result received from main Activity
     */
    public void setText(String result){

        Utils.printLog(TAG,"inside setText" + result);

        etxtab3.setText(result);

        Utils.printLog(TAG,"outside setText");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Utils.printLog(TAG,"inside onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {

        Utils.printLog(TAG,"inside onAttach");

        super.onAttach(context);
        listner = (FragementCommunication) context;
        Utils.printLog(TAG,"outside onAttach");
    }
}
