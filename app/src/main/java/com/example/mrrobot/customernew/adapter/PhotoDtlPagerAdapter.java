package com.example.mrrobot.customernew.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mrrobot.customernew.R;

/**
 * Created by Mr Robot on 2/8/2018.
 */

public class PhotoDtlPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.tes, R.drawable.hair_cut, R.drawable.hair_coloring};

    public PhotoDtlPagerAdapter(Context context){this.context = context;}


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_services, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.service_image_view);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.service_image_view2);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.service_image_view3);


        imageView.setImageResource(images[position]);
        imageView2.setImageResource(images[position]);
        imageView3.setImageResource(images[position]);


        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        ViewPager vp = (ViewPager) container;
        View view = (View)object;
        vp.removeView(view);
    }
}
