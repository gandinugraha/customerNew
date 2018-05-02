package com.example.mrrobot.customernew.view_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrrobot.customernew.R;

/**
 * Created by Mr Robot on 11/23/2017.
 */

public class StylishViewHolder extends RecyclerView.ViewHolder {
    public ImageView stylishImage;
    public TextView stylishName;

    public TextView stylishMonHour;
    public TextView stylishTueHour;
    public TextView stylishWedHour;
    public TextView stylishThuHour;
    public TextView stylishFriHour;
    public TextView stylishSatHour;
    public TextView stylishSunHour;

    public Button stylishMasterPieces;


    public StylishViewHolder(View itemView) {
        super(itemView);

        stylishImage = (ImageView) itemView.findViewById(R.id.vh_stylish_image);
        stylishName = (TextView) itemView.findViewById(R.id.vh_stylish_name);
        stylishMonHour = (TextView) itemView.findViewById(R.id.vh_stylish_mon_work_hour);
        stylishTueHour = (TextView) itemView.findViewById(R.id.vh_stylish_tue_work_hour);
        stylishWedHour = (TextView) itemView.findViewById(R.id.vh_stylish_wed_work_hour);
        stylishThuHour = (TextView) itemView.findViewById(R.id.vh_stylish_thu_work_hour);
        stylishFriHour = (TextView) itemView.findViewById(R.id.vh_stylish_fri_work_hour);
        stylishSatHour = (TextView) itemView.findViewById(R.id.vh_stylish_sat_work_hour);
        stylishSunHour = (TextView) itemView.findViewById(R.id.vh_stylish_sun_work_hour);

        stylishMasterPieces = (Button) itemView.findViewById(R.id.vh_mst_pieces_btn);
    }
}
