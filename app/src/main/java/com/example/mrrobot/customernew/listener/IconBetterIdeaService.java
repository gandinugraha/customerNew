package com.example.mrrobot.customernew.listener;

import com.example.mrrobot.customernew.model.IconBetterIdea;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Mr Robot on 2/22/2018.
 */

public interface IconBetterIdeaService {
    @GET
    Call<IconBetterIdea>getIconUrl(@Url String url);
}
