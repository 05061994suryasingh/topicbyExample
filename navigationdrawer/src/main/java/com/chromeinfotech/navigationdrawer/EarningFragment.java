package com.chromeinfotech.navigationdrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 13/4/17.
 */
public class EarningFragment extends android.support.v4.app.Fragment {

    public EarningFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.earning_fragement, container, false);

        return rootView;
    }
}
