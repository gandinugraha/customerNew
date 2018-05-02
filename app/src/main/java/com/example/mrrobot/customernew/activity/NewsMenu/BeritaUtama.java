package com.example.mrrobot.customernew.activity.NewsMenu;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.activity.HomeActivity;
import com.example.mrrobot.customernew.activity.ProfileActivity;
import com.example.mrrobot.customernew.activity.ReviewFeedActivity;
import com.example.mrrobot.customernew.activity.StylishLocationActivity;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BeritaUtama extends AppCompatActivity {

    String API_KEY = "8190df9eb51445228e397e4185311a66"; // ### YOUE NEWS API HERE ###
    String NEWS_SOURCE = "bbc-news";
    ListView listNews;
    ProgressBar loader;

    ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
    static final String KEY_AUTHOR = "author";
    static final String KEY_TITLE = "title";
    static final String KEY_DESCRIPTION = "description";
    static final String KEY_URL = "url";
    static final String KEY_URLTOIMAGE = "urlToImage";
    static final String KEY_PUBLISHEDAT = "publishedAt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.berita_utama);

        initMenu(this);

        listNews = (ListView) findViewById(R.id.listNews);
        loader = (ProgressBar) findViewById(R.id.loader);
        listNews.setEmptyView(loader);



        if(Function.isNetworkAvailable(getApplicationContext()))
        {
            DownloadNews newsTask = new DownloadNews();
            newsTask.execute();
        }else{
            Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
        }

    }


    class DownloadNews extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        protected String doInBackground(String... args) {
            String xml = "";

            String urlParameters = "";
            xml = Function.excuteGet("https://newsapi.org/v1/articles?source="+NEWS_SOURCE+"&sortBy=top&apiKey="+API_KEY, urlParameters);
            return  xml;
        }
        @Override
        protected void onPostExecute(String xml) {

            if(xml.length()>10){ // Just checking if not empty

                try {
                    JSONObject jsonResponse = new JSONObject(xml);
                    JSONArray jsonArray = jsonResponse.optJSONArray("articles");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put(KEY_AUTHOR, jsonObject.optString(KEY_AUTHOR).toString());
                        map.put(KEY_TITLE, jsonObject.optString(KEY_TITLE).toString());
                        map.put(KEY_DESCRIPTION, jsonObject.optString(KEY_DESCRIPTION).toString());
                        map.put(KEY_URL, jsonObject.optString(KEY_URL).toString());
                        map.put(KEY_URLTOIMAGE, jsonObject.optString(KEY_URLTOIMAGE).toString());
                        map.put(KEY_PUBLISHEDAT, jsonObject.optString(KEY_PUBLISHEDAT).toString());
                        dataList.add(map);
                    }
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "Unexpected error", Toast.LENGTH_SHORT).show();
                }

                ListNewsAdapter adapter = new ListNewsAdapter(BeritaUtama.this, dataList);
                listNews.setAdapter(adapter);

                listNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Intent i = new Intent(BeritaUtama.this, DetailBerita.class);
                        i.putExtra("url", dataList.get(+position).get(KEY_URL));
                        startActivity(i);
                    }
                });

            }else{
                Toast.makeText(getApplicationContext(), "No news found", Toast.LENGTH_SHORT).show();
            }
        }
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
        } else if ((mcontext instanceof BeritaUtama)) {
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
