package com.example.mrrobot.customernew.utility;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Mr Robot on 12/19/2017.
 */

public class RequestQueUtil {

    private static RequestQueUtil mInstance;
    private static Context context;
    private RequestQueue requestQueue;

    private RequestQueUtil(Context ctx) {
        this.context = ctx;
        requestQueue = getRequestQueue();
    }

    private RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }

        return requestQueue;
    }

    public static synchronized RequestQueUtil getmInstance(Context context) {
        if (mInstance == null) {
            mInstance = new RequestQueUtil(context);
        }

        return mInstance;
    }

    public <T> void addToRequestQue(Request request) {
        getRequestQueue().add(request);
    }
}
