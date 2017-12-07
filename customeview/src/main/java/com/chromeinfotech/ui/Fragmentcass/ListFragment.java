package com.chromeinfotech.ui.Fragmentcass;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.chromeinfotech.ui.BaseActivity.FragementCommunication;
import com.chromeinfotech.customeview.R;
import com.chromeinfotech.utils.Utils;

/**
 * ListFragment contains editText and button, and pass edittext data  to MainActivity and main Activity pass to Details Fragment
 */
public class ListFragment extends Fragment{


    private String TAG = this.getClass().getSimpleName();
    private FragementCommunication listner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        Utils.printLog(TAG,"inside onCreateView");

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        LinearLayout linearlayout = (LinearLayout) view.findViewById(R.id.linearlayout);
        this.addview(linearlayout, inflater);//call addview method

        Utils.printLog(TAG,"outside onCreateView");
        return view;
    }

//add view to liner layout on fragment (ListFragment)
    private void addview(LinearLayout linearlayout, LayoutInflater inflater) {

        Utils.printLog(TAG,"inside addview");

        for(int i = 0 ; i < 5 ; i ++){
            View view = inflater.inflate(R.layout.itemlayout , null);
            Button  buttonclick = (Button) view.findViewById(R.id.buttonclick);
            final EditText edittext = (EditText) view.findViewById(R.id.edittext);

            //set onclickListner on button buttonclick
            buttonclick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    String msg = edittext.getText().toString();//get  the value of EditText and store to msg
                    //bundle.putString("message",msg);
                    listner.onItemSelected(msg);//call the method of FragementCommunication interface and pass the edittext value
                }
            });
            linearlayout.addView(view);//add view to linear layout
        }
        Utils.printLog(TAG,"outside addview");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listner = (FragementCommunication) context;//upcastin is perform context is the parent class of Activity
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
