package com.example.mrrobot.customernew.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.model.Masterpiece;
import com.example.mrrobot.customernew.view_holder.MasterpieceViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr Robot on 12/18/2017.
 */

public class MasterpieceGalleryViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private RecyclerView masterpieceContainer;
    private List<Masterpiece> masterpieces;
    private Masterpiece masterpiece;
    private Context context;

    public MasterpieceGalleryViewAdapter(RecyclerView recyclerView, ArrayList<Masterpiece> masterpieces, Context context){
        this.masterpieceContainer = recyclerView;
        this.masterpieces = masterpieces;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_masterpiece, parent, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, masterpieceContainer.getWidth()));
        return new MasterpieceViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        masterpiece = masterpieces.get(position);

        final MasterpieceViewHolder masterpieceViewHolder = (MasterpieceViewHolder) holder;

        Picasso.with(context)
                .load(masterpiece.getImgThumbnailUrl())
                .placeholder(R.drawable.stylish)
                .error(R.drawable.stylish)
                .into(((MasterpieceViewHolder) holder).masterpieceImg);

    }


    @Override
    public int getItemCount() {
        return masterpieces.size();
    }
}
