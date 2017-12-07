package com.chromeinfotech.mapassignment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by user on 19/4/17.
 */

public class InfoAdapter  implements GoogleMap.InfoWindowAdapter {
    LayoutInflater inflater = null;
    private TextView textViewTitle;

    public InfoAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        View view = inflater.inflate(R.layout.infowindow , null);
        if (marker != null) {
            textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
            textViewTitle.setText(marker.getTitle());
        }
        return (view);
    }

    @Override
    public View getInfoContents(Marker marker) {
        return (null);
    }

    }