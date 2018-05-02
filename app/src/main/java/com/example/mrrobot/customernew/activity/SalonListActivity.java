package com.example.mrrobot.customernew.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.activity.NewsMenu.BeritaUtama;
import com.example.mrrobot.customernew.adapter.SalonListViewAdapter;
import com.example.mrrobot.customernew.listener.OnLoadSalonListener;
import com.example.mrrobot.customernew.model.Salon;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SalonListActivity extends AppCompatActivity {


    private Context context;
    private Toolbar titleToolbar;
    private RecyclerView salonListView, salonPromoListView;
    private Button searchSalonBtn;
    //    RecyclerView recyclerView;
    //ImageView im1;
    //Bitmap bit;

    private List<Salon> salons = new ArrayList<>();
    private SalonListViewAdapter salonListViewAdapter, salonPromoViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_list);

        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LocationActivity.class);

                startActivity(i);
            }
        });


        this.context = this;

        initMenu(this);

        for (int i = 0; i < 10; i++) {
            Salon salon = new Salon.Builder()
                    .salonId(UUID.randomUUID().toString())
                    .salonName("Fortune Salon" + " " + i)
                    .salonAddress("Jl. Jelambar Barat No 32A Jakarta Barat DKI Jakarta")
                    .salonManagerName("Fransiscus Rosida")
                    .salonManagerUser("fransiscus.rosida@gmail.com")
                    .salonRating("4.1")
                    .salonTotalReview(" " + "(1000 reviews )")
                    .salonImageUrl("https://images-na.ssl-images-amazon.com/images/M/MV5BMTM3ODgzMDc5OF5BMl5BanBnXkFtZTcwMDcxNTgwMw@@._CR384,0,1105,1638_UX402_UY596._SY298_SX201_AL_.jpg")
                    .salonSubscriptionStatus(true)
                    .salonTotalStylish("7 Stylish")
                    .build();
            salons.add(salon);


        }
        //==========================================================================================

        salonPromoListView = (RecyclerView) findViewById(R.id.recycleListHome);
        salonPromoListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        salonPromoViewAdapter = new SalonListViewAdapter(salonPromoListView, salons, context);
        salonPromoListView.setAdapter(salonPromoViewAdapter);

        final Animation an = AnimationUtils.loadAnimation(getBaseContext(),R.anim.slide_in_right);
        salonPromoListView.startAnimation(an);

        salonListView = (RecyclerView) findViewById(R.id.recycleListHome);
        salonListView.setLayoutManager(new LinearLayoutManager(this));
        salonListViewAdapter = new SalonListViewAdapter(salonListView, salons, context);

        salonListViewAdapter.setOnLoadMoreListener(new OnLoadSalonListener() {
            @Override
            public void onLoadMore() {
                salonListView.post(new Runnable() {
                    @Override
                    public void run() {
                        salons.add(null);
                        salonListViewAdapter.notifyItemInserted(salons.size() - 1);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("haint", "Load More 2");

                                //Remove loading item
                                salons.remove(salons.size() - 1);
                                salonListViewAdapter.notifyItemRemoved(salons.size());

                                //Load data =================================================================================
                                int index = salons.size();
                                int end = index + 10;
                                for (int i = index; i < end; i++) {
                                    Salon salon = new Salon.Builder()
                                            .salonId(UUID.randomUUID().toString())
                                            .salonName("Fortune Salon" + " " + i)
                                            .salonAddress("Jl. Jelambar Barat No 32A Jakarta Barat DKI Jakarta")
                                            .salonManagerName("Fransiscus Rosida")
                                            .salonManagerUser("fransiscus.rosida@gmail.com")
                                            .salonRating("4.1")
                                            .salonTotalReview(" " + "(1000 reviews )")
                                            .salonImageUrl("https://images-na.ssl-images-amazon.com/images/M/MV5BMTM3ODgzMDc5OF5BMl5BanBnXkFtZTcwMDcxNTgwMw@@._CR384,0,1105,1638_UX402_UY596._SY298_SX201_AL_.jpg")
                                            .salonSubscriptionStatus(true)
                                            .salonTotalStylish("7 Stylish")
                                            .build();
                                    salons.add(salon);
                                }
                                // ==========================================================================================

                                salonListViewAdapter.notifyDataSetChanged();
                                salonListViewAdapter.setLoaded();
                            }
                        }, 3000);
                    }
                });
            }
        });

        salonListView.setAdapter(salonListViewAdapter);


//        ImageView imageView = new ImageView(this); // Create an icon
//        imageView.setImageResource(R.drawable.ic_cardaction_positive);
//
//
//        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
//                .setContentView(imageView)
//                .build();
    }

    private void initMenu(Context context) {
        final Context mcontext = context;


        ImageButton locationMenu = (ImageButton) findViewById(R.id.menu_location);
        ImageButton salonMenu = (ImageButton) findViewById(R.id.menu_salon);
        ImageButton stylishMenu = (ImageButton) findViewById(R.id.menu_stylish);
        ImageButton masterpieceMenu = (ImageButton) findViewById(R.id.menu_masterpiece);
        ImageButton profileMenu = (ImageButton) findViewById(R.id.menu_profile);


        if ((mcontext instanceof HomeActivity)) {
            locationMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
        } else if ((mcontext instanceof SalonActivity)) {
            salonMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
        } else if ((mcontext instanceof StylishLocationActivity)) {
            stylishMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
        } else if ((mcontext instanceof ReviewFeedActivity)) {
            masterpieceMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
        } else if ((mcontext instanceof ProfileActivity)) {
            profileMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
        }

        locationMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(mcontext instanceof HomeActivity)) {
                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(i);
                    overridePendingTransition(0, 0);
                    finish();
                }
            }
        });


        salonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(mcontext instanceof BeritaUtama)) {
                    Intent i = new Intent(getApplicationContext(), BeritaUtama.class);
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
                if (!(mcontext instanceof ReviewFeedActivity)) {
                    Intent i = new Intent(getApplicationContext(), ReviewFeedActivity.class);
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
