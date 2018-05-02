package com.example.mrrobot.customernew.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.activity.NewsMenu.BeritaUtama;
import com.example.mrrobot.customernew.adapter.MasterpieceGalleryViewAdapter;
import com.example.mrrobot.customernew.model.Masterpiece;

import java.util.ArrayList;

/**
 * Created by Mr Robot on 12/28/2017.
 */

public class MasterpieceGalleryActivity extends AppCompatActivity{

    private Context context;
    private Toolbar titleToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masterpieces_gallery);

        this.context = this;


        initMenu(this);

        ArrayList<Masterpiece> arrayList = new ArrayList<>();

        for (int i =0; i<20 ; i++){
            arrayList.add(new Masterpiece("1", "Masterpieces 1", "https://od.lk/s/121195309_xa4Rd/Cover.jpg", "https://od.lk/s/121195309_xa4Rd/Cover.jpg"));
            arrayList.add(new Masterpiece("2", "Masterpieces 2", "http://2.bp.blogspot.com/-UsJTY2MNIsQ/Vd2B6sVBMgI/AAAAAAAAB-I/IKbha0XFbKk/s1600/HAIRSTYLE%2B%25282%2529.jpg", "http://2.bp.blogspot.com/-UsJTY2MNIsQ/Vd2B6sVBMgI/AAAAAAAAB-I/IKbha0XFbKk/s1600/HAIRSTYLE%2B%25282%2529.jpg"));
            arrayList.add(new Masterpiece("3", "Masterpieces 3", "https://data.whicdn.com/images/117841103/large.jpg", "https://data.whicdn.com/images/117841103/large.jpg"));
            arrayList.add(new Masterpiece("4", "Masterpieces 4", "https://data.whicdn.com/images/108002916/original.jpg", "https://data.whicdn.com/images/108002916/original.jpg"));
            arrayList.add(new Masterpiece("5", "Masterpieces 5", "http://s3.weddbook.com/t4/2/5/1/2513457/mother-of-groom-wedding-hair.jpg", "http://s3.weddbook.com/t4/2/5/1/2513457/mother-of-groom-wedding-hair.jpg"));
            arrayList.add(new Masterpiece("6", "Masterpieces 6", "https://i.pinimg.com/736x/9a/be/3b/9abe3b6d65e7c54e0569029602058168--braided-hair-tutorials-hairstyle-tutorials.jpg", "https://i.pinimg.com/736x/9a/be/3b/9abe3b6d65e7c54e0569029602058168--braided-hair-tutorials-hairstyle-tutorials.jpg"));
            arrayList.add(new Masterpiece("7", "Masterpieces 7", "https://cdn.shopify.com/s/files/1/1653/3529/products/1-PC-Women-Lady-French-Hair-Braiding-Tool-Braider-Roller-Hook-With-font-b-Magic-b_grande.jpg?v=1498125699", "https://cdn.shopify.com/s/files/1/1653/3529/products/1-PC-Women-Lady-French-Hair-Braiding-Tool-Braider-Roller-Hook-With-font-b-Magic-b_grande.jpg?v=1498125699"));

        }

        RecyclerView masterpieceGalleryGontainer = (RecyclerView) findViewById(R.id.masterpiece_gallery_container);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        masterpieceGalleryGontainer.setLayoutManager(layoutManager);
        MasterpieceGalleryViewAdapter recyclerAdapter = new MasterpieceGalleryViewAdapter(masterpieceGalleryGontainer, arrayList, this);
        masterpieceGalleryGontainer.setAdapter(recyclerAdapter);
    }

    private void initMenu(Context context){
        final Context mcontext = context;

        ImageButton locationMenu = (ImageButton)findViewById(R.id.menu_location);
        ImageButton salonMenu = (ImageButton)findViewById(R.id.menu_salon);
        ImageButton stylishMenu = (ImageButton)findViewById(R.id.menu_stylish);
        ImageButton masterpieceMenu = (ImageButton)findViewById(R.id.menu_masterpiece);
        ImageButton profileMenu = (ImageButton)findViewById(R.id.menu_profile);

        /*
        Button locationMenu = (Button)findViewById(R.id.menu_location);
        Button salonMenu = (Button)findViewById(R.id.menu_salon);
        Button stylishMenu = (Button)findViewById(R.id.menu_stylish);
        Button masterpieceMenu = (Button)findViewById(R.id.menu_masterpiece);
        Button profileMenu = (Button)findViewById(R.id.menu_profile);
        */

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
