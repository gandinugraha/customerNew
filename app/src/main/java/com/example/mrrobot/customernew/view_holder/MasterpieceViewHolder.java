package com.example.mrrobot.customernew.view_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.mrrobot.customernew.R;


/**
 * Created by Mr Robot on 11/20/2017.
 */

public class MasterpieceViewHolder extends RecyclerView.ViewHolder {

    public ImageView masterpieceImg;


    public MasterpieceViewHolder(View itemView) {
        super(itemView);
        masterpieceImg = (ImageView) itemView.findViewById(R.id.masterpiece_gallery_thumbnail);
    }

}
