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
 *send data to mainactivity and mainactivity sen that data to fragment1
 */

public class Fragment1 extends Fragment {

    private  TextView  txttab1 ;
    private  EditText  etxtab1 ;
    private Button btnclick1 ;
    private String TAG = this.getClass().getSimpleName() ;
    private FragementCommunication listner ;
    private String data ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Utils.printLog(TAG,"inside onCreateView");

        View view = inflater.inflate(R.layout.tab1 , container, false); //inflate the tab1
        this.setReference(view);
        this.setListner();

        Utils.printLog(TAG,"outside onCreateView");
        return view;
    }

    /**
     * set the references
     * @param view
     */
    private void setReference(View view) {
        Utils.printLog(TAG,"inside setReference");

        txttab1   = (TextView) view.findViewById(R.id.txttab1);
        etxtab1   = (EditText) view.findViewById(R.id.etxtab1);
        btnclick1 = (Button)   view.findViewById(R.id.btnclick1);

        Utils.printLog(TAG,"outside setReference");
    }

    /**
     * set the OnClickListener listner on button
     */
    private void setListner() {
        Utils.printLog(TAG , "inside setListner");
        btnclick1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data =etxtab1.getText().toString();
                listner.onItemSelected(data);
            }
        });
        Utils.printLog(TAG,"outside setListner");
    }

    /**
     * set text to text view whe tab is selected
     * @param result
     */
    public void setText(String result){

        Utils.printLog(TAG,"inside setText" + result);

        etxtab1.setText(result);

        Utils.printLog(TAG,"outside setText");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Utils.printLog(TAG,"inside onCreate");
        super.onCreate(savedInstanceState);
    }

    public Fragment1() {
    }
    @Override
    public void onAttach(Context context) {

        Utils.printLog(TAG,"inside onAttach");
        super.onAttach(context);
        listner = (FragementCommunication) context;//upcasting  is perform context is the parent class of Activity
        Utils.printLog(TAG,"outside onAttach");
    }
}
