package com.example.mrrobot.customernew.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.activity.HomeActivity;
import com.example.mrrobot.customernew.activity.ProfileActivity;
import com.example.mrrobot.customernew.activity.SalonDetailActivity;
import com.example.mrrobot.customernew.listener.OnLoadSalonListener;
import com.example.mrrobot.customernew.model.Salon;
import com.example.mrrobot.customernew.view_holder.LoadingViewHolder;
import com.example.mrrobot.customernew.view_holder.SalonViewHolder;

import java.util.List;

/**
 * Created by Mr Robot on 12/18/2017.
 */

public class SalonViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private boolean isLoading;
    private int lastVisibleItem, totalItemCount;
    private int visibleThreshold = 5;

    private OnLoadSalonListener onLoadMoreListener;

    private RecyclerView mRecyclerView;
    private List<Salon> salons;
    private Context context;

    //constraktor
    public SalonViewAdapter(RecyclerView recyclerView, List<Salon> salons, Context context) {
        this.mRecyclerView = recyclerView;
        this.salons = salons;
        this.context = context;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();

                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLoadMore();
                    }
                    isLoading = true;
                }
            }
        });
    }


    public void setOnLoadMoreListener(OnLoadSalonListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    @Override
    public int getItemViewType(int position) {
        return salons.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM){
            View view = LayoutInflater.from(context).inflate(R.layout.viewholder_salon, parent, false);
            return new SalonViewHolder(view);
        }else if (viewType == VIEW_TYPE_LOADING){
            View view = LayoutInflater.from(context).inflate(R.layout.viewholder_loading, parent, false);
            return new LoadingViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof SalonViewHolder){
            final Salon mSalon;
            mSalon = salons.get(position);

            SalonViewHolder salonViewHolder = (SalonViewHolder) holder;

            salonViewHolder.salonName.setText(mSalon.getSalonName());
            salonViewHolder.salonAddress.setText(mSalon.getSalonAddress());
            salonViewHolder.salonReviewerTotal.setText(mSalon.getSalonTotalReview());
            salonViewHolder.salonStylishTotal.setText(mSalon.getSalonTotalStylish());

            salonViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, HomeActivity.class);
                }
            });
        } else if (holder instanceof LoadingViewHolder){
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }

    }

    @Override
    public int getItemCount() {
        return salons == null ? 0 : salons.size();
    }

    public void setLoaded (){
        isLoading = false;
    }
}
