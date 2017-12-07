package com.chromeinfotech.ui.Fragmentcass;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.chromeinfotech.ui.BaseActivity.BaseActivity;
import com.chromeinfotech.ui.BaseActivity.FragementCommunication;
import com.chromeinfotech.customeview.R;
import com.chromeinfotech.utils.Utils;

public class MainActivity extends BaseActivity implements FragementCommunication {
    private String TAG = this.getClass().getSimpleName();
    private FrameLayout framelayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils.printLog(TAG,"inside onCreate()");

        this.reference();
        this.addfragement();

        Utils.printLog(TAG,"outside onCreate()");
    }

    /**
     * add listFragment if framelayout is not dualpain
     */
    private void addfragement() {
        Utils.printLog(TAG,"inside addfragement()");
        try {
            if (this.isDoublePain()) {
                return;
            } else {
                ListFragment listFragment = new ListFragment();
                FragmentTransaction fragmentTransaction = Utils.getFragmenttransaction(this);
                fragmentTransaction.add(R.id.framelayout, listFragment);
                fragmentTransaction.commit();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Utils.printLog(TAG,"outside addfragement()");
    }

    /**
     * check framelayout doualpain or not
     * @return
     */
    private boolean isDoublePain() {
        Utils.printLog(TAG, "inside isDoublePain()");
        if(framelayout == null){
            return  true;
        }else
        return false;

    }

    //method of FragementCommunication and check Detailsfragement is creeated or not if created then call the method setText() otherwise pass data using bundle
    @Override
    public void onItemSelected(String msg) {
        Utils.printLog(TAG, "inside onItemSelected()");
        if (isDoublePain()) {
            DetailsFragment df = (DetailsFragment) Utils.getFragmentManager(this)
                    .findFragmentById(R.id.detailsFragment);
            if(df != null){
                df.setText(msg);
            }
            return;
        } else {

            DetailsFragment fragement = new DetailsFragment();
            Bundle bundle1 = new Bundle();
            bundle1.putString("message",msg);
            fragement.setArguments(bundle1);
            this.replaceFragment(fragement);

        }

        Utils.printLog(TAG,"outside onItemSelected()");
    }

    //replace list fragement to details fragement and also perform fragment transition
    private void replaceFragment(DetailsFragment fragement) {
        Utils.printLog(TAG,"inside replaceFragment()");

        FragmentTransaction transaction = Utils.getFragmenttransaction(this);
        //transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        transaction.setCustomAnimations(R.animator.slide_up_animation, R.animator.slide_down_animation,R.animator.slide_up_animation, R.animator.slide_down_animation);
        transaction.replace(R.id.framelayout, fragement);
        transaction.addToBackStack(null);
        transaction.commit();
        Utils.printLog(TAG,"outside replaceFragment()");
    }

    /**
     * set the reference
     */
    @Override
    public void reference() {

        Utils.printLog(TAG,"inside reference");

        framelayout = (FrameLayout) this.findViewById(R.id.framelayout);
        Utils.printLog(TAG,"outside reference");
    }

    /**
     * set the listner
     */
    @Override
    public void setListenrs() {

        Utils.printLog(TAG,"inside setListenrs");


        Utils.printLog(TAG,"outside setListenrs");

    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Utils.printLog(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Utils.printLog(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Utils.printLog(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Utils.printLog(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Utils.printLog(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Utils.printLog(TAG, "onDestroy()");
    }
}
