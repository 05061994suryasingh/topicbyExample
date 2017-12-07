package com.chromeinfotech.ui.Fragmentcass;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.chromeinfotech.customeview.R;
import com.chromeinfotech.utils.Utils;

/**
 * DetailsFragment show the details of list fragment edittext
 */
public class DetailsFragment extends Fragment {

    private String TAG = this.getClass().getSimpleName();
    private TextView textdetail = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        Utils.printLog(TAG,"inside onCreateView");

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragement_details , container , false);
        this.setReferences(view);// set the reference

        Bundle bundle=getArguments();//get the data from bundle
        if(bundle!=null) {
            String string= bundle.getString("message");
            textdetail.setText(string);
        }



        Utils.printLog(TAG,"outside onCreateView");
        return view;
    }

    @Override
    public void onAttach(Context context) {

        Utils.printLog(TAG,"inside onAttach");

        super.onAttach(context);

        Utils.printLog(TAG,"outside onAttach");

    }
    //set the Reference with the lelp of view
    private void setReferences(View view){

        Utils.printLog(TAG,"inside setReferences");

        textdetail = (TextView) view.findViewById(R.id.textdetail);

        Utils.printLog(TAG,"outside setReferences");
    }
    //recive result from mainActivity and setvalue into textbox on DetailsFragment
    public void setText(String result){

        Utils.printLog(TAG,"inside setText"+result);

        textdetail.setText(result);

        Utils.printLog(TAG,"outside setText");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Utils.printLog(TAG,"inside onActivityCreated");

    }

    @Override
    public void onStart() {
        super.onStart();
        Utils.printLog(TAG,"inside onstart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Utils.printLog(TAG,"inside onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Utils.printLog(TAG,"inside onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Utils.printLog(TAG,"inside onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Utils.printLog(TAG,"inside onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Utils.printLog(TAG,"inside onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Utils.printLog(TAG,"inside onDetach");
    }
}
