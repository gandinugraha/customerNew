package com.example.mrrobot.customernew.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.mrrobot.customernew.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import static android.content.ContentValues.TAG;


public class SalonDtlInfoFragment extends Fragment {

    private FragmentActivity myContext;
    private MapView mMapView;
    private GoogleMap mMap;


    private final static int REQUEST_LOCATION = 1, REQUEST_BUY = 3, REQUEST_PERMISSIONS = 4;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.salon_dtl_information_fragment,container, false);
        mMapView = (MapView) viewGroup.findViewById(R.id.salon_map_location);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        }catch (Exception e){
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
                if (checkPermission()){
                    mMap.setMyLocationEnabled(true);
                }else {
                    askPermission();
                }
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-6.1686271, 106.7869014), 13f));
                mMap.addMarker(new MarkerOptions().position(new LatLng(-6.1686271, 106.7869014)));
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            }
        });

        return viewGroup;
    }

    //check permission
    private boolean checkPermission(){
        Log.d(TAG, "checkPermission()");
        return (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED);
    }

    //asks for permission
    private void askPermission(){
        Log.d(TAG, "askPermission()");
        ActivityCompat.requestPermissions(getActivity(), new String[]
                {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSIONS);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        Log.d(TAG, "onRequestPermissionsResult()");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_PERMISSIONS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //permision granted
                    if(checkPermission())mMap.setMyLocationEnabled(true);

                }else {
                    // permission denied
                }
                break;
            }
        }
    }


    @Override
    public void onResume(){
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory(){
        super.onLowMemory();
        mMapView.onLowMemory();
    }


}
