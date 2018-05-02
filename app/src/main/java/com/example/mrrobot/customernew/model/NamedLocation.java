package com.example.mrrobot.customernew.model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Mr Robot on 12/19/2017.
 */

public class NamedLocation {

    public final String name;

    public final LatLng location;

    NamedLocation(String name, LatLng location) {
        this.name = name;
        this.location = location;
    }
}
