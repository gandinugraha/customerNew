package com.example.mrrobot.customernew.view_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrrobot.customernew.R;



public class SalonViewHolder extends RecyclerView.ViewHolder {

    public ImageView salonImage;
    public TextView salonName;
    public TextView salonReviewerTotal;
    public TextView salonStylishTotal;
    public TextView salonAddress;

    public SalonViewHolder(View itemView) {
        super(itemView);

        salonImage =(ImageView) itemView.findViewById(R.id.salon_image);
        salonName = (TextView) itemView.findViewById( R.id.salon_name);
        salonReviewerTotal = (TextView) itemView.findViewById(R.id.salon_reviewer_total);
        salonStylishTotal = (TextView) itemView.findViewById(R.id.salon_stylish_total);
        salonAddress = (TextView) itemView.findViewById(R.id.salon_address);

    }
}
