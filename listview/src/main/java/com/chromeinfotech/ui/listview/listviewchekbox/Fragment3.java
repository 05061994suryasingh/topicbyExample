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

public class Fragment3 extends Fragment {
    private  TextView txttab3 ;
    private FragementCommunication listner;
    private String TAG = this.getClass().getSimpleName();
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        Utils.printLog(TAG,"inside onCreateView");
        View view = inflater.inflate(R.layout.tab3, container, false);
        this.reference(view);
        this.setListner();
        Utils.printLog(TAG,"outside onCreateView");

        return view;
    }

    private void reference(View view) {
        Utils.printLog(TAG,"inside reference");
        txttab3   = (TextView) view.findViewById(R.id.txttab3);
        Utils.printLog(TAG,"outside reference");
    }

    private void setListner() {
        Utils.printLog(TAG,"inside setListner");

        Utils.printLog(TAG,"outside setListner");
    }

    public Fragment3() {

    }

    public void setText(String result){

        Utils.printLog(TAG,"inside setText" + result);


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
