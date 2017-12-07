package com.chromeinfotech.ui.listview.listviewchekbox;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chromeinfotech.listview.R;
import com.chromeinfotech.ui.ViewPager.Viewpagerwithfragement.FragementCommunication;
import com.chromeinfotech.utils.Utils;

/**
 * Created by user on 17/3/17.
 */

public class Fragment1 extends Fragment {
    private  TextView  txttab1 ;
    private String TAG = this.getClass().getSimpleName();
    private FragementCommunication listner;
    String data ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Utils.printLog(TAG,"inside onCreateView");

        View view = inflater.inflate(R.layout.fragement1layout, container, false);
        this.setReference(view);
        this.setListner();

        Utils.printLog(TAG,"outside onCreateView");
        return view;
    }

    private void setReference(View view) {
        Utils.printLog(TAG,"inside setReference");
        txttab1   = (TextView) view.findViewById(R.id.txttab1);

        Utils.printLog(TAG,"outside setReference");
    }

    private void setListner() {
        Utils.printLog(TAG,"inside setListner");

        Utils.printLog(TAG,"outside setListner");
    }
    public void setText(String result){

        Utils.printLog(TAG,"inside setText" + result);



        Utils.printLog(TAG,"outside setText");
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        Utils.printLog(TAG,"inside onCreate");super.onCreate(savedInstanceState);
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
