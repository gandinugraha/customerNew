package com.example.mrrobot.customernew.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.adapter.SalonDetailPagerAdapter;
import com.example.mrrobot.customernew.fragment.MasterpiecesFragment;
import com.example.mrrobot.customernew.fragment.SalonDtlInfoFragment;
import com.example.mrrobot.customernew.fragment.SalonDtlPromoFragment;
import com.example.mrrobot.customernew.fragment.SalonDtlReviewFragment;
import com.example.mrrobot.customernew.fragment.SalonDtlServiceFragment;
import com.example.mrrobot.customernew.fragment.SalonDtlStylishFragment;


public class SalonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState, persistentState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_dtl);
        initMenu(this);


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        // Set Tabs inside Toolbar
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        int betweenSpace = 10;

        ViewGroup slidingTabStrip = (ViewGroup) tabLayout.getChildAt(0);

        tabLayout.setupWithViewPager(viewPager);
        for (int i=0; i<slidingTabStrip.getChildCount(); i++){
            View v = slidingTabStrip.getChildAt(i);
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            params.rightMargin = betweenSpace;
            params.leftMargin = betweenSpace;
        }

        ImageButton imageButton = (ImageButton)findViewById(R.id.menu_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LocationActivity.class);

                startActivity(i);
            }
        });


    }


    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        SalonDetailPagerAdapter adapter = new SalonDetailPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SalonDtlInfoFragment(), "Information");
        adapter.addFragment(new SalonDtlServiceFragment(), "Services");
        adapter.addFragment(new SalonDtlStylishFragment(), "Stylish");
        adapter.addFragment(new SalonDtlReviewFragment(), "Review");
        adapter.addFragment(new SalonDtlPromoFragment(), "Promos");
        adapter.addFragment(new MasterpiecesFragment(), "Masterpieces");
        viewPager.setAdapter(adapter);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    private void initMenu(Context context) {
        final Context mcontext = context;
        ImageButton locationMenu = (ImageButton) findViewById(R.id.menu_location);
        ImageButton salonMenu = (ImageButton) findViewById(R.id.menu_salon);
        ImageButton stylishMenu = (ImageButton) findViewById(R.id.menu_stylish);
        ImageButton masterpieceMenu = (ImageButton) findViewById(R.id.menu_masterpiece);
        ImageButton profileMenu = (ImageButton) findViewById(R.id.menu_profile);

        locationMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(mcontext instanceof HomeActivity)) {
                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(i);
                    overridePendingTransition(0, 0);
                }
            }
        });

        salonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(mcontext instanceof SalonDetailActivity) && !(mcontext instanceof SalonDetailActivity)) {
                    Intent i = new Intent(getApplicationContext(), SalonActivity.class);
                    startActivity(i);
                    overridePendingTransition(0, 0);
                }
            }
        });

        stylishMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(mcontext instanceof StylishLocationActivity)) {
                    Intent i = new Intent(getApplicationContext(), StylishLocationActivity.class);
                    startActivity(i);
                    overridePendingTransition(0, 0);
                }
            }
        });

        masterpieceMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(mcontext instanceof MasterpieceGalleryActivity)) {
                    Intent i = new Intent(getApplicationContext(), MasterpieceGalleryActivity.class);
                    startActivity(i);
                    overridePendingTransition(0, 0);
                }
            }
        });

        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(mcontext instanceof ProfileActivity)) {
                    Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(i);
                    overridePendingTransition(0, 0);
                }
            }
        });

    }

}
