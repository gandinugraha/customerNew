package com.example.mrrobot.customernew.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.activity.NewsMenu.BeritaUtama;
import com.example.mrrobot.customernew.adapter.SalonDetailPagerAdapter;
import com.example.mrrobot.customernew.fragment.FollowedFragment;
import com.example.mrrobot.customernew.fragment.FollowerFragment;
import com.example.mrrobot.customernew.fragment.PhotoDtlFragment;
import com.example.mrrobot.customernew.fragment.ReviewProfilFragment;
import com.example.mrrobot.customernew.fragment.SalonDtlReviewFragment;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;


public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        initMenu(this);

        Picasso.with(this)
                .load("https://organicthemes.com/demo/profile/files/2012/12/profile_img.png")
                .transform(new CropCircleTransformation())
                .into((ImageView) findViewById(R.id.profile_img));

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpagerprofil);
        setupViewPager(viewPager);

        // Set Tabs inside Toolbar
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout1);
        int betweenSpace = 10;
        ViewGroup slidingTabStrip = (ViewGroup) tabLayout.getChildAt(0);

        tabLayout.setupWithViewPager(viewPager);
        for (int i=0; i<slidingTabStrip.getChildCount(); i++){
            View v = slidingTabStrip.getChildAt(i);
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            params.rightMargin = betweenSpace;
            params.leftMargin = betweenSpace;
        }
    }


    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        SalonDetailPagerAdapter adapter = new SalonDetailPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ReviewProfilFragment(), "Review");
        adapter.addFragment(new PhotoDtlFragment(), "Photos");
        adapter.addFragment(new FollowerFragment(), "Follower");
        adapter.addFragment(new FollowedFragment(), "Followed");



        viewPager.setAdapter(adapter);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }


    private void initMenu(Context context){
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
                if(!(mcontext instanceof BeritaUtama)){
                    Intent i = new Intent(getApplicationContext(), BeritaUtama.class);
                    startActivity(i);
                    overridePendingTransition(0, 0);
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
                }
            }
        });


    }
}