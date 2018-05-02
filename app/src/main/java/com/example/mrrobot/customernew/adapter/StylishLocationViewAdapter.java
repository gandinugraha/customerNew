package com.example.mrrobot.customernew.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.model.StylishLocation;
import com.example.mrrobot.customernew.view_holder.StylishLocationViewHolder;
import com.example.mrrobot.customernew.view_holder.StylishViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Mr Robot on 12/19/2017.
 */

public class StylishLocationViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private RecyclerView stylishLocationContainer;
    private List<StylishLocation> stylishLocations;
    private StylishLocation stylishLocation;
    private Context context;

    public StylishLocationViewAdapter(RecyclerView recyclerView, List<StylishLocation> stylishLocations,Context context){
        this.stylishLocationContainer = recyclerView;
        this.stylishLocations = stylishLocations;
        this.context = context;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_stylish_location, parent, false);
        return new StylishLocationViewHolder(view);




    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        stylishLocation = stylishLocations.get(position);



        final StylishLocationViewHolder stylishLocationViewHolder = (StylishLocationViewHolder) holder;
//        stylishLocationViewHolder.stylishName.setText(stylishLocation.getStylishName());


        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String imgThumbnailUrl = stylishLocation.getStylishThumbnailImgUrl();
                //if (position > 0)
                //  imgThumbnailUrl = stylishLocation.getStylishThumbnailImgUrl() + position;
                Picasso.with(context)
                        .load(imgThumbnailUrl)
                        .placeholder(R.drawable.stylish)
                        .error(R.drawable.stylish)
                        .into((stylishLocationViewHolder).stylishThumbnailImg);
            }
        };
        handler.postDelayed(runnable, 800 + (position*100));

    }

    @Override
    public int getItemCount() {
        return stylishLocations.size();
    }
}
