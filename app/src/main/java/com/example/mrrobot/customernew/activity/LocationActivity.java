package com.example.mrrobot.customernew.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v4.app.Fragment;
import android.view.View;

import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.adapter.CustomInfoWindowAdapter;
import com.example.mrrobot.customernew.adapter.SalonViewAdapter;
import com.example.mrrobot.customernew.model.Salon;



import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Mr Robot on 12/8/2017.
 */

public class LocationActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener
        , GoogleMap.OnMapClickListener {


    private GoogleMap mMap;

    private LatLng salonLocation;
    private LatLng currentLocation;
    private LatLngBounds bounds;

    private RecyclerView salonLocationListView;
    private SalonViewAdapter salonListViewAdapter;
    private List<Salon> salonCustomer = new ArrayList<>();

    private static final CameraPosition ADELAIDE_CAMERA = new CameraPosition.Builder()
            .target(new LatLng(-6.1686271, 106.7869014)).zoom(16.0f).bearing(0).tilt(0).build();

    private Marker mSelectedMarker;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingDetail);

        ImageButton imageButton = (ImageButton)findViewById(R.id.icon_search);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GooglePlaceActivity.class);

                startActivity(i);
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SalonDetailActivity.class);

                startActivity(i);
            }
        });



        initMenu(this);

//        salonLocationListView = (RelativeLayout) findViewById(R.id.relative1);
//        salonLocationListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        salonListViewAdapter = new SalonViewAdapter(salonLocationListView, salonCustomer, this);
//        salonLocationListView.setAdapter(salonListViewAdapter);



        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_location);
        mapFragment.getMapAsync(this);
    }



    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Test Resume on Location");
    }



    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        LatLngBounds.Builder boundBuilder = new LatLngBounds.Builder();
        MapStyleOptions style;
        style = MapStyleOptions.loadRawResourceStyle(this, R.raw.mapstyle_retro);
        mMap.setMapStyle(style);
        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(this));
        mMap.setOnMarkerClickListener(this);
        mMap.setOnMapClickListener(this);



        salonLocation = new LatLng(-6.1686271, 106.7869014);
        mMap.addMarker(new MarkerOptions().position(salonLocation).title("Rudy Salon").snippet("Citraland"));
        boundBuilder.include(salonLocation);

        salonLocation = new LatLng(-6.1787572, 106.7899197); //Taman Anggrek
        mMap.addMarker(new MarkerOptions().position(salonLocation).title("Rudy Salon").snippet("Taman Anggrek"));
        boundBuilder.include(salonLocation);

        salonLocation = new LatLng(-6.153641, 106.7942636); //Season City
        mMap.addMarker(new MarkerOptions().position(salonLocation).title("Rudy Salon").snippet("Season City"));
        boundBuilder.include(salonLocation);

        bounds = boundBuilder.build();

        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100));

    }


    @Override
    public void onMapClick(LatLng latLng) {

        mSelectedMarker = null;

        salonCustomer = new ArrayList<>();
        salonListViewAdapter = new SalonViewAdapter(salonLocationListView, salonCustomer, this);
        salonListViewAdapter.notifyItemRemoved(salonCustomer.size());
        salonLocationListView.setAdapter(salonListViewAdapter);

    }


    @Override
    public boolean onMarkerClick(final Marker marker) {
        if (marker.equals(mSelectedMarker)) {
            mSelectedMarker = null;

            salonCustomer = new ArrayList<>();
            salonListViewAdapter = new SalonViewAdapter(salonLocationListView, salonCustomer, this);
            salonListViewAdapter.notifyItemRemoved(salonCustomer.size());
            salonLocationListView.setAdapter(salonListViewAdapter);

            return true;
        }

        mSelectedMarker = marker;

        //dummy data
        for (int i = 0; i < 10; i++) {
            Salon salonCustomer = new Salon.Builder()
                    .salonId(UUID.randomUUID().toString())
                    .salonName("Rudy Salon - Kelapa Gading" + " " + i)
                    .salonAddress("Jl Jelambar Barat No 32A Jakarta Barat DKI Jakarta")
                    .salonManagerName("Mr Robot")
                    .salonManagerUser("Mrrobot@gmail.com")
                    .salonRating("4.1")
                    .salonTotalReview(" " + "(1000 reviews)")
                    .salonImageUrl("https://images-na.ssl-images-amazon.com/images/M/MV5BMTM3ODgzMDc5OF5BMl5BanBnXkFtZTcwMDcxNTgwMw@@._CR384,0,1105,1638_UX402_UY596._SY298_SX201_AL_.jpg")
                    .salonSubscriptionStatus(true)
                    .salonTotalStylish("7 Stylish")
                    .build();
            this.salonCustomer.add(salonCustomer);
        }

        salonListViewAdapter.notifyItemRemoved(salonCustomer.size());
        return false;
    }


    private void initMenu(Context context) {
        final Context mcontext = context;


        ImageButton locationMenu = (ImageButton) findViewById(R.id.menu_location);
        ImageButton salonMenu = (ImageButton) findViewById(R.id.menu_salon);
        ImageButton stylishMenu = (ImageButton) findViewById(R.id.menu_stylish);
        ImageButton masterpieceMenu = (ImageButton) findViewById(R.id.menu_masterpiece);
        ImageButton profileMenu = (ImageButton) findViewById(R.id.menu_profile);


        if ((mcontext instanceof LocationActivity)) {
            locationMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
        } else if ((mcontext instanceof SalonActivity)) {
            salonMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
        } else if ((mcontext instanceof StylishLocationActivity)) {
            stylishMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
        } else if ((mcontext instanceof MasterpieceGalleryActivity)) {
            masterpieceMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
        } else if ((mcontext instanceof ProfileActivity)) {
            profileMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
        }

        locationMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(mcontext instanceof LocationActivity)) {
                    Intent i = new Intent(getApplicationContext(), LocationActivity.class);
                    startActivity(i);
                    overridePendingTransition(0, 0);
                    finish();
                }
            }
        });


        salonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(mcontext instanceof SalonActivity)) {
                    Intent i = new Intent(getApplicationContext(), SalonActivity.class);
                    startActivity(i);
                    overridePendingTransition(0, 0);
                    finish();
                }
            }
        });

        stylishMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(mcontext instanceof StylishLocationActivity)) {
                    Intent i = new Intent(getApplicationContext(), StylishLocationActivity.class);
                    startActivity(i);
                    overridePendingTransition(0, 0);
                    finish();
                }
            }
        });

        masterpieceMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(mcontext instanceof MasterpieceGalleryActivity)) {
                    Intent i = new Intent(getApplicationContext(), MasterpieceGalleryActivity.class);
                    startActivity(i);
                    overridePendingTransition(0, 0);
                    finish();
                }
            }
        });

        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(mcontext instanceof ProfileActivity)) {
                    Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(i);
                    overridePendingTransition(0, 0);
                    finish();
                }
            }
        });

    }

}
