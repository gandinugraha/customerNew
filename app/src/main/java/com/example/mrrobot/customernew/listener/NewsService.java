package com.example.mrrobot.customernew.listener;

import com.example.mrrobot.customernew.model.News;
import com.example.mrrobot.customernew.model.WebSite;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Mr Robot on 2/22/2018.
 */

public interface NewsService {
    @GET("v1/sources?language=en")
    Call<WebSite> getSources();

    @GET
    Call<News>getNewestArtiles(@Url String url);

}
