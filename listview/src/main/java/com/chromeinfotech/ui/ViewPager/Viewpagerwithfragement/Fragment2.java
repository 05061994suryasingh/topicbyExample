package com.chromeinfotech.ui.ViewPager.Viewpagerwithfragement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
 * show the first fragment textview data of firstfragment in textview
 */

public class Fragment2 extends Fragment {

    private  TextView txttab2 ;
    private EditText  etxtab2 ;
    private FragementCommunication listner;
    private Button btnclick2;
    private String TAG = this.getClass().getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Utils.printLog(TAG,"inside onCreateView");

        View view = inflater.inflate(R.layout.tab2, container, false); //inflate the tab2
        this.setReferences(view);
        this.setListner();

        Utils.printLog(TAG,"outside onCreateView");
        return view;
    }

    /**
     * set OnClickListener listner on button
     */
    private void setListner() {
        Utils.printLog(TAG,"inside setListner");
        btnclick2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  data = etxtab2.getText().toString();
                listner.onItemSelected(data);
            }
        });
        Utils.printLog(TAG,"outside setListner");

    }


    @Override
    public void onAttach(Context context) {

        Utils.printLog(TAG,"inside onAttach");

        super.onAttach(context);
        listner = (FragementCommunication) context;
        Utils.printLog(TAG,"outside onAttach");

    }

    /**
     * set the reference
     * @param view
     */
    private void setReferences(View view) {
        Utils.printLog(TAG,"inside setReferences");
        txttab2 = (TextView) view.findViewById(R.id.txttab2);
        etxtab2 = (EditText) view.findViewById(R.id.etxtab2);
        btnclick2 = (Button)   view.findViewById(R.id.btnclick2);
        Utils.printLog(TAG,"outside setReferences");
    }

    /**
     * set text to textview
     * @param result received from  main activity which is send by fragment1
     */
    public void setText(String result){

        Utils.printLog(TAG,"inside setText" + result);

        etxtab2.setText(result);

        Utils.printLog(TAG,"outside setText");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Utils.printLog(TAG,"inside onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Utils.printLog(TAG,"inside onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    public Fragment2() {

    }


}
