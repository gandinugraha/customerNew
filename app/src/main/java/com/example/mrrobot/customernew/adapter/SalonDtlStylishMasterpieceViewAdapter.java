package com.example.mrrobot.customernew.adapter;


import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.model.Masterpiece;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mr Robot on 12/18/2017.
 */

public class SalonDtlStylishMasterpieceViewAdapter extends RecyclerView.Adapter<SalonDtlStylishMasterpieceViewAdapter.MyViewHolder>{

    ArrayList<Masterpiece> arrayList = new ArrayList<>();
    Activity activity;

    public SalonDtlStylishMasterpieceViewAdapter(ArrayList<Masterpiece> arrayList, Context context){
        this.arrayList = arrayList;
        this.activity = (Activity) context;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_stylish_masterpiece, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SalonDtlStylishMasterpieceViewAdapter.MyViewHolder holder, int position) {
        holder.title.setText(arrayList.get(position).getTitle());
        //Glide.with(activity).load(arrayList.get(position).getTitle()).placeholder(R.drawable.digital_art01).error(R.drawable.digital_art01).into(holder.thumbnail);
        Picasso.with(activity)
                .load(arrayList.get(position).getImgThumbnailUrl())
                .placeholder(R.drawable.masterpiece_default)
                .into(holder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView thumbnail;
        TextView title;

        public MyViewHolder(View itemView){
            super(itemView);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            title = (TextView) itemView.findViewById(R.id.album_title);
        }
    }
}
