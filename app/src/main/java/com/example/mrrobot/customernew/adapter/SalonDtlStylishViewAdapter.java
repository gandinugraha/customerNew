package com.example.mrrobot.customernew.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.listener.OnLoadSalonStylishListener;
import com.example.mrrobot.customernew.model.Masterpiece;
import com.example.mrrobot.customernew.model.SalonDtlStylish;
import com.example.mrrobot.customernew.view_holder.LoadingViewHolder;
import com.example.mrrobot.customernew.view_holder.StylishViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr Robot on 12/18/2017.
 */

public class SalonDtlStylishViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private int lastVisibleItem, totalItemCount;
    private int visibleThreshold = 5;
    private boolean isLoading;

    private OnLoadSalonStylishListener onLoadMoreListener;

    private RecyclerView mRecyclerView;
    private List<SalonDtlStylish> salonDtlStylishes;
    private Context context;
    private Activity activity;

    public SalonDtlStylishViewAdapter(RecyclerView recyclerView, List<SalonDtlStylish> salonDtlStylishes, Context context, Activity activity) {
        this.mRecyclerView = recyclerView;
        this.salonDtlStylishes = salonDtlStylishes;
        this.context = context;
        this.activity = activity;

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

    public void setOnLoadMoreListener(OnLoadSalonStylishListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    @Override
    public int getItemViewType(int position) {
        return salonDtlStylishes.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(context).inflate(R.layout.viewholder_stylish_location, parent, false);
            return new StylishViewHolder(view);
        } else if (viewType == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(context).inflate(R.layout.viewholder_loading, parent, false);
            return new LoadingViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof StylishViewHolder) {
            final SalonDtlStylish salonDtlStylish;
            salonDtlStylish = salonDtlStylishes.get(position);

            StylishViewHolder StylishViewHolder = (StylishViewHolder) holder;

            StylishViewHolder.stylishName.setText(salonDtlStylish.getStylishName());
            StylishViewHolder.stylishMonHour.setText(salonDtlStylish.getStylishMondayHours());
            StylishViewHolder.stylishTueHour.setText(salonDtlStylish.getStylishTuesdayHours());
            StylishViewHolder.stylishWedHour.setText(salonDtlStylish.getStylishWednesdayHours());
            StylishViewHolder.stylishThuHour.setText(salonDtlStylish.getStylishThursdayHours());
            StylishViewHolder.stylishFriHour.setText(salonDtlStylish.getStylishFridayHours());
            StylishViewHolder.stylishSatHour.setText(salonDtlStylish.getStylishSaturdayHours());
            StylishViewHolder.stylishSunHour.setText(salonDtlStylish.getStylishSundayHours());

            StylishViewHolder.stylishMasterPieces.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(activity);
                    View mView = activity.getLayoutInflater().inflate(R.layout.dialog_stylish_masterpieces, null);

                    Toolbar titleToolbar = (Toolbar) mView.findViewById(R.id.toolbar);
                    titleToolbar.setTitle("Stylish Masterpieces");

                    RecyclerView stylishMasterpiecesContainer = (RecyclerView) mView.findViewById(R.id.stylish_mstpieces_container);
                    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(activity, 2);
                    stylishMasterpiecesContainer.setLayoutManager(layoutManager);

                    //TODO - Dummy Data
                    ArrayList<Masterpiece> arrayList = new ArrayList<>();
                    arrayList.add(new Masterpiece("1", "Masterpieces 1", "https://od.lk/s/121195309_xa4Rd/Cover.jpg", "https://od.lk/s/121195309_xa4Rd/Cover.jpg"));
                    arrayList.add(new Masterpiece("2", "Masterpieces 2", "http://2.bp.blogspot.com/-UsJTY2MNIsQ/Vd2B6sVBMgI/AAAAAAAAB-I/IKbha0XFbKk/s1600/HAIRSTYLE%2B%25282%2529.jpg", "http://2.bp.blogspot.com/-UsJTY2MNIsQ/Vd2B6sVBMgI/AAAAAAAAB-I/IKbha0XFbKk/s1600/HAIRSTYLE%2B%25282%2529.jpg"));
                    arrayList.add(new Masterpiece("3", "Masterpieces 3", "https://data.whicdn.com/images/117841103/large.jpg", "https://data.whicdn.com/images/117841103/large.jpg"));
                    arrayList.add(new Masterpiece("4", "Masterpieces 4", "https://data.whicdn.com/images/108002916/original.jpg", "https://data.whicdn.com/images/108002916/original.jpg"));
                    arrayList.add(new Masterpiece("5", "Masterpieces 5", "http://s3.weddbook.com/t4/2/5/1/2513457/mother-of-groom-wedding-hair.jpg", "http://s3.weddbook.com/t4/2/5/1/2513457/mother-of-groom-wedding-hair.jpg"));
                    arrayList.add(new Masterpiece("6", "Masterpieces 6", "https://i.pinimg.com/736x/9a/be/3b/9abe3b6d65e7c54e0569029602058168--braided-hair-tutorials-hairstyle-tutorials.jpg", "https://i.pinimg.com/736x/9a/be/3b/9abe3b6d65e7c54e0569029602058168--braided-hair-tutorials-hairstyle-tutorials.jpg"));
                    arrayList.add(new Masterpiece("7", "Masterpieces 7", "https://cdn.shopify.com/s/files/1/1653/3529/products/1-PC-Women-Lady-French-Hair-Braiding-Tool-Braider-Roller-Hook-With-font-b-Magic-b_grande.jpg?v=1498125699", "https://cdn.shopify.com/s/files/1/1653/3529/products/1-PC-Women-Lady-French-Hair-Braiding-Tool-Braider-Roller-Hook-With-font-b-Magic-b_grande.jpg?v=1498125699"));


                    SalonDtlStylishMasterpieceViewAdapter recyclerAdapter = new SalonDtlStylishMasterpieceViewAdapter(arrayList, activity);
                    stylishMasterpiecesContainer.setAdapter(recyclerAdapter);

                    mBuilder.setView(mView);

                    mBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
                    final AlertDialog dialog = mBuilder.create();
                    dialog.setCancelable(false);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.show();
                }
            });

        } else if (holder instanceof LoadingViewHolder) {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }

    }

    @Override
    public int getItemCount() {
        return salonDtlStylishes == null ? 0 : salonDtlStylishes.size();
    }

    public void setLoaded() {
        isLoading = false;
    }
}
