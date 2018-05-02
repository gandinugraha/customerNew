package com.example.mrrobot.customernew.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toolbar;

import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.adapter.SalonViewAdapter;
import com.example.mrrobot.customernew.listener.OnLoadSalonListener;
import com.example.mrrobot.customernew.model.Salon;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SalonActivity extends AppCompatActivity {

    private Context context;
    private Toolbar titleToolbar;
    private RecyclerView salonListView, salonPromoListView;
    private Button searchSalonBtn;

    private List<Salon> salons = new ArrayList<>();
    private SalonViewAdapter salonViewAdapter, salonPromoViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon);

        this.context = this;

        initMenu(context);

        for (int i = 0; i < 10; i++) {
            Salon salon = new Salon.Builder()
                    .salonId(UUID.randomUUID().toString())
                    .salonName("Rudy Salon - Kelapa Gading" + " " + i)
                    .salonAddress("Jl. Jelambar Barat No 32A Jakarta Barat DKI Jakarta")
                    .salonManagerName("MrRobot")
                    .salonManagerUser("mrRobot@gmail.com")
                    .salonRating("4.1")
                    .salonTotalReview(" " + "(1000 reviews )")
                    .salonImageUrl("https://images-na.ssl-images-amazon.com/images/M/MV5BMTM3ODgzMDc5OF5BMl5BanBnXkFtZTcwMDcxNTgwMw@@._CR384,0,1105,1638_UX402_UY596._SY298_SX201_AL_.jpg")
                    .salonSubscriptionStatus(true)
                    .salonTotalStylish("7 Stylish")
                    .build();
            salons.add(salon);
        }

        salonPromoListView = (RecyclerView) findViewById(R.id.salon_promo_container);
        salonPromoListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        salonPromoViewAdapter = new SalonViewAdapter(salonPromoListView, salons, context);
        salonPromoListView.setAdapter(salonPromoViewAdapter);

        final Animation an = AnimationUtils.loadAnimation(getBaseContext(), R.anim.slide_in_right);
        salonPromoListView.startAnimation(an);

        salonListView = (RecyclerView) findViewById(R.id.salon_container);
        salonListView.setLayoutManager(new LinearLayoutManager(this));
        salonViewAdapter = new SalonViewAdapter(salonListView, salons, context);

        salonViewAdapter.setOnLoadMoreListener(new OnLoadSalonListener() {
            @Override
            public void onLoadMore() {
                salonListView.post(new Runnable() {
                    @Override
                    public void run() {
                        salons.add(null);
                        salonViewAdapter.notifyItemChanged(salons.size() - 1);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("haint", "Load more 2");

                                //remove loading item
                                salons.remove(salons.size() - 1);
                                salonViewAdapter.notifyItemRemoved(salons.size());

                                //load Data
                                int index = salons.size();
                                int end = index + 10;
                                for (int i = index; i < end; i++) {
                                    Salon salon = new Salon.Builder()
                                            .salonId(UUID.randomUUID().toString())
                                            .salonName("Rudy Salon - Kelapa Gading" + " " + i)
                                            .salonAddress("Jl. Jelambar Barat No 32A Jakarta Barat DKI Jakarta")
                                            .salonManagerName("MrRobot")
                                            .salonManagerUser("mrRobot@gmail.com")
                                            .salonRating("4.1")
                                            .salonTotalReview(" " + "(1000 reviews )")
                                            .salonImageUrl("https://images-na.ssl-images-amazon.com/images/M/MV5BMTM3ODgzMDc5OF5BMl5BanBnXkFtZTcwMDcxNTgwMw@@._CR384,0,1105,1638_UX402_UY596._SY298_SX201_AL_.jpg")
                                            .salonSubscriptionStatus(true)
                                            .salonTotalStylish("7 Stylish")
                                            .build();
                                    salons.add(salon);
                                }

                                salonViewAdapter.notifyDataSetChanged();
                                salonViewAdapter.setLoaded();
                            }
                        }, 3000);
                    }
                });
            }
        });

        salonListView.setAdapter(salonViewAdapter);
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
        } else if ((mcontext instanceof SalonActivity)){
            salonMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
        } else if ((mcontext instanceof StylishLocationActivity)){
            stylishMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
        } else if ((mcontext instanceof MasterpieceGalleryActivity)){
            masterpieceMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
        } else if ((mcontext instanceof ProfileActivity)){
            profileMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
        }

        locationMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(mcontext instanceof LocationActivity)){
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
                if(!(mcontext instanceof SalonActivity)) {
                    Intent i = new Intent(getApplicationContext(), SalonActivity.class);
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
                if(!(mcontext instanceof MasterpieceGalleryActivity)) {
                    Intent i = new Intent(getApplicationContext(), MasterpieceGalleryActivity.class);
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
