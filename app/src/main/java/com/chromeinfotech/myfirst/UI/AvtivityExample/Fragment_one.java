package com.chromeinfotech.myfirst.UI.AvtivityExample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chromeinfotech.myfirst.R;

/**
 * Created by user on 2/3/17.
 */

public class Fragment_one extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tab1, container, false);
    }
}
