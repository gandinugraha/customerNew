package com.example.mrrobot.customernew.common;

import com.example.mrrobot.customernew.listener.IconBetterIdeaService;
import com.example.mrrobot.customernew.listener.NewsService;
import com.example.mrrobot.customernew.remote.IconBetterIdeaClient;
import com.example.mrrobot.customernew.remote.RetrofitClient;

/**
 * Created by Mr Robot on 2/22/2018.
 */

public class Common {

    private static final String BASE_URL = "https://newsapi.org/";

    public static final String API_KEY = "9485619e2b974dde9fcf0d427cd878de";

    public static NewsService getNewsService() {
        return RetrofitClient.getClient(BASE_URL).create(NewsService.class);
    }

    public static IconBetterIdeaService getIconService() {
        return IconBetterIdeaClient.getClient().create(IconBetterIdeaService.class);
    }


    //https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest&apiKey=a7072d9c2ad9495a8dd5cb58a7fd30df
    public static String getAPIUrl(String source, String sortBy, String apiKEY) {
        StringBuilder apiUrl = new StringBuilder("https://newsapi.org/v1/articles?source=");
        return apiUrl.append(source)
                .append("&sortBy=")
                .append(sortBy)
                .append("&apiKey=")
                .append(apiKEY)
                .toString();
    }
}
