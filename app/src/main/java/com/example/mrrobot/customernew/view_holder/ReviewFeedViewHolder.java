package com.example.mrrobot.customernew.view_holder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrrobot.customernew.R;

public class ReviewFeedViewHolder extends RecyclerView.ViewHolder {

    public ImageView salonImage;
    public TextView salonName;
    public TextView salonReviewerTotal;


    public ReviewFeedViewHolder(View itemView) {
        super(itemView);


        salonImage =(ImageView) itemView.findViewById(R.id.reviewer_img);
        salonName = (TextView) itemView.findViewById( R.id.reviewer_name);
        salonReviewerTotal = (TextView) itemView.findViewById(R.id.reviewer_total_review );
    }
}
