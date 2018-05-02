package com.example.mrrobot.customernew.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.mrrobot.customernew.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by Mr Robot on 12/12/2017.
 */

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter{

    private final View mWindow;

    public CustomInfoWindowAdapter(Context context){
        mWindow = ((Activity)context).getLayoutInflater().inflate(R.layout.window_custom_info,null);
    }


    @Override
    public View getInfoWindow(Marker marker) {
        render(marker, mWindow);
        return mWindow;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    private void render(Marker marker, View view){
        int badge;

        String title = marker.getTitle();
        TextView titleUi = ((TextView) view.findViewById(R.id.title));
        if(title != null){
            titleUi.setText(title);
        }else {
            titleUi.setText("");
        }

        String snippet = marker.getSnippet();
        TextView snippetUi = ((TextView) view.findViewById(R.id.snippet));

        if(snippet != null){
            snippetUi.setText(snippet);
        }else {
            snippetUi.setText("");
        }
    }
}
