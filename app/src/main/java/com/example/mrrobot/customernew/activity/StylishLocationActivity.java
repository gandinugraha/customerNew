package com.example.mrrobot.customernew.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toolbar;


import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.activity.NewsMenu.BeritaUtama;
import com.example.mrrobot.customernew.adapter.StylishLocationViewAdapter;
import com.example.mrrobot.customernew.model.StylishLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Mr Robot on 12/19/2017.
 */

public class StylishLocationActivity extends AppCompatActivity {

    private Context context;
    private Toolbar titleToolbar;

    private RecyclerView stylishLocationListView;
    private StylishLocationViewAdapter stylishLocationViewAdapter;
    private List<StylishLocation> stylishLocations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stylish_location);



        this.context = this;

        initMenu(context);

        //dummy data
        for (int i = 0; i < 20; i++){
            StylishLocation stylishLocation = new StylishLocation.Builder()
                    .stylishId(UUID.randomUUID().toString()).salonId(UUID.randomUUID().toString())
                    .stylishName("Stylish " +i)
                    .stylishThumbnailImgUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRoytWCrTjBpRVxs5-Bz6lJf_IoCbzCYv8ty2hFFFpRvL29fHyN1A")
                    .build();
            stylishLocations.add(stylishLocation);
        }

        stylishLocationListView = (RecyclerView) findViewById(R.id.stylish_location_container);
        stylishLocationListView.setLayoutManager(new GridLayoutManager(this,3));

        stylishLocationViewAdapter = new StylishLocationViewAdapter(stylishLocationListView, stylishLocations, context);
        stylishLocationListView.setAdapter(stylishLocationViewAdapter);
    }


    private void initMenu (Context context){
        final Context mcontext = context;

        ImageButton locationMenu = (ImageButton)findViewById(R.id.menu_location);
        ImageButton salonMenu = (ImageButton)findViewById(R.id.menu_salon);
        ImageButton stylishMenu = (ImageButton)findViewById(R.id.menu_stylish);
        ImageButton masterpieceMenu = (ImageButton)findViewById(R.id.menu_masterpiece);
        ImageButton profileMenu = (ImageButton)findViewById(R.id.menu_profile);

        if ((mcontext instanceof HomeActivity)){
            locationMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
        } else if ((mcontext instanceof BeritaUtama)){
            salonMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
        } else if ((mcontext instanceof StylishLocationActivity)){
            stylishMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
        } else if ((mcontext instanceof ReviewFeedActivity)){
            masterpieceMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
        } else if ((mcontext instanceof ProfileActivity)){
            profileMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
        }

        locationMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(mcontext instanceof HomeActivity)){
                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(i);
                    overridePendingTransition(0, 0);
                    finish();
                }

            }
        });

        salonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(mcontext instanceof BeritaUtama)) {
                    Intent i = new Intent(getApplicationContext(), BeritaUtama.class);
                    startActivity(i);
                    overridePendingTransition(0, 0);
                    finish();
                }
            }
        });

        stylishMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(mcontext instanceof StylishLocationActivity)) {
                    Intent i = new Intent(getApplicationContext(), StylishLocationActivity.class);
                    startActivity(i);
                    overridePendingTransition(0, 0);
                    finish();
                }
            }
        });

        masterpieceMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(mcontext instanceof ReviewFeedActivity)) {
                    Intent i = new Intent(getApplicationContext(), ReviewFeedActivity.class);
                    startActivity(i);
                    overridePendingTransition(0, 0);
                    finish();
                }
            }
        });

        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(mcontext instanceof ProfileActivity)) {
                    Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(i);
                    overridePendingTransition(0, 0);
                    finish();
                }
            }
        });
    }
}
