package com.example.mrrobot.customernew.activity;

import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.adapter.ListNewsAdapter;
import com.example.mrrobot.customernew.common.Common;
import com.example.mrrobot.customernew.listener.NewsService;
import com.example.mrrobot.customernew.model.Article;
import com.example.mrrobot.customernew.model.News;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.github.florent37.diagonallayout.DiagonalLayout;
import com.squareup.picasso.Picasso;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListNewsActivity extends AppCompatActivity {

    KenBurnsView kbv;
    DiagonalLayout diagonalLayout;
    AlertDialog dialog;
    NewsService mService;
    TextView top_author, top_title;
    SwipeRefreshLayout swipeRefreshLayout;

    String source = "", sortBy = "", webHotURL = "";

    ListNewsAdapter adapter;
    RecyclerView lstNews;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);



//        initMenu(this);

        //service
        mService = Common.getNewsService();

        dialog = new SpotsDialog(this);

        //view
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                loadNews(source, true);
            }
        });

        diagonalLayout = (DiagonalLayout) findViewById(R.id.diagonalLayout);
        diagonalLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail = new Intent(getBaseContext(), DetailArticleActivity.class);
                detail.putExtra("webUrl", webHotURL);
                startActivity(detail);
            }
        });


        kbv = (KenBurnsView) findViewById(R.id.top_image);
        top_author = (TextView) findViewById(R.id.top_author);
        top_title = (TextView) findViewById(R.id.top_title);

        lstNews = (RecyclerView) findViewById(R.id.lstNews);
        lstNews.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        lstNews.setLayoutManager(layoutManager);

        //intent
        if (getIntent() != null) {
            source = getIntent().getStringExtra("source");
            sortBy = getIntent().getStringExtra("sortBy");
            if (!source.isEmpty() && !sortBy.isEmpty()) {
                loadNews(source, false);
            }
        }
    }

    private void loadNews(String source, boolean isRefreshed) {
        if (!isRefreshed) {
            dialog.show();
            mService.getNewestArtiles(Common.getAPIUrl(source, sortBy, Common.API_KEY))
                    .enqueue(new Callback<News>() {
                        @Override
                        public void onResponse(Call<News> call, Response<News> response) {
                            dialog.dismiss();
                            //get first article
                            Picasso.with(getBaseContext())
                                    .load(response.body().getArticles().get(0).getUrlToImage())
                                    .into(kbv);

                            top_title.setText(response.body().getArticles().get(0).getTitle());
                            top_author.setText(response.body().getArticles().get(0).getAuthor());


                            webHotURL = response.body().getArticles().get(0).getUrl();

                            //load remain articles
                            List<Article> removeFristItem = response.body().getArticles();


                            removeFristItem.remove(0);
                            adapter = new ListNewsAdapter(removeFristItem, getBaseContext());
                            adapter.notifyDataSetChanged();
                            lstNews.setAdapter(adapter);
                        }

                        @Override
                        public void onFailure(Call<News> call, Throwable t) {

                        }
                    });
        } else {
            dialog.show();
            mService.getNewestArtiles(Common.getAPIUrl(source, sortBy, Common.API_KEY))
                    .enqueue(new Callback<News>() {
                        @Override
                        public void onResponse(Call<News> call, Response<News> response) {
                            dialog.dismiss();
                            //get first article
                            Picasso.with(getBaseContext())
                                    .load(response.body().getArticles().get(0).getUrlToImage())
                                    .into(kbv);

                            top_title.setText(response.body().getArticles().get(0).getTitle());
                            top_author.setText(response.body().getArticles().get(0).getAuthor());


                            webHotURL = response.body().getArticles().get(0).getUrl();

                            //load remain articles
                            List<Article> removeFristItem = response.body().getArticles();
                            removeFristItem.remove(0);
                            adapter = new ListNewsAdapter(removeFristItem, getBaseContext());
                            adapter.notifyDataSetChanged();
                            lstNews.setAdapter(adapter);
                        }

                        @Override
                        public void onFailure(Call<News> call, Throwable t) {

                        }
                    });
            swipeRefreshLayout.setRefreshing(false);
        }

    }

//    private void initMenu(Context context) {
//        final Context mcontext = context;
//
//
//        ImageButton locationMenu = (ImageButton) findViewById(R.id.menu_location);
//        ImageButton salonMenu = (ImageButton) findViewById(R.id.menu_salon);
//        ImageButton stylishMenu = (ImageButton) findViewById(R.id.menu_stylish);
//        ImageButton masterpieceMenu = (ImageButton) findViewById(R.id.menu_masterpiece);
//        ImageButton profileMenu = (ImageButton) findViewById(R.id.menu_profile);
//
//
//        if ((mcontext instanceof HomeActivity)) {
//            locationMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
//        } else if ((mcontext instanceof SalonActivity)) {
//            salonMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
//        } else if ((mcontext instanceof StylishLocationActivity)) {
//            stylishMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
//        } else if ((mcontext instanceof ReviewFeedActivity)) {
//            masterpieceMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
//        } else if ((mcontext instanceof ProfileActivity)) {
//            profileMenu.setBackgroundColor(ContextCompat.getColor(mcontext, R.color.orange));
//        }

//        locationMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!(mcontext instanceof LocationActivity)) {
//                    Intent i = new Intent(getApplicationContext(), LocationActivity.class);
//                    startActivity(i);
//                    overridePendingTransition(0, 0);
//                    finish();
//                }
//            }
//        });
//
//
//        salonMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!(mcontext instanceof BeritaUtama)) {
//                    Intent i = new Intent(getApplicationContext(), BeritaUtama.class);
//                    startActivity(i);
//                    overridePendingTransition(0, 0);
//                    finish();
//                }
//            }
//        });
//
//        stylishMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!(mcontext instanceof StylishLocationActivity)) {
//                    Intent i = new Intent(getApplicationContext(), StylishLocationActivity.class);
//                    startActivity(i);
//                    overridePendingTransition(0, 0);
//                    finish();
//                }
//            }
//        });
//
//        masterpieceMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!(mcontext instanceof ReviewFeedActivity)) {
//                    Intent i = new Intent(getApplicationContext(), ReviewFeedActivity.class);
//                    startActivity(i);
//                    overridePendingTransition(0, 0);
//                    finish();
//                }
//            }
//        });
//
//        profileMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!(mcontext instanceof ProfileActivity)) {
//                    Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
//                    startActivity(i);
//                    overridePendingTransition(0, 0);
//                    finish();
//                }
//            }
//        });
//
//    }

//    }
}