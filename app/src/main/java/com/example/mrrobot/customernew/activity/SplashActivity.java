package com.example.mrrobot.customernew.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.mrrobot.customernew.R;


public class SplashActivity  extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final ImageView iv = (ImageView) findViewById(R.id.stylish_image);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(),R.anim.zoom_in);
        final Animation an2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.zoom_out);

        iv.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv.startAnimation(an2);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        an2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                //Intent i = new Intent(getBaseContext(),MainActivity.class);
                Intent i = new Intent(getBaseContext(),HomeActivity.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
