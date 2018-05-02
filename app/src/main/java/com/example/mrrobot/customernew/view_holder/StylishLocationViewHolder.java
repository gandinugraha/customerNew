package com.example.mrrobot.customernew.view_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrrobot.customernew.R;

/**
 * Created by Mr Robot on 12/19/2017.
 */

public class StylishLocationViewHolder extends RecyclerView.ViewHolder {

    public TextView stylishName;
    public ImageView stylishThumbnailImg;


    public StylishLocationViewHolder(View itemView) {
        super(itemView);
//        stylishName = (TextView) itemView.findViewById(R.id.loc_stylish_name);
        stylishThumbnailImg = (ImageView) itemView.findViewById(R.id.loc_stylish_img);
    }
}
