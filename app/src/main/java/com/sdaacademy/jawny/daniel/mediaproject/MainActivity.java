package com.sdaacademy.jawny.daniel.mediaproject;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void animate(final View view) {
        Animation animationFirst = AnimationUtils.loadAnimation(this, R.anim.spinn_first);
        final Animation animationSecond = AnimationUtils.loadAnimation(this, R.anim.spinn_second);
        animationFirst.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.mysterious);
                mediaPlayer.setOnCompletionListener(MainActivity.this);
                mediaPlayer.start();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(animationSecond);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(animationFirst);
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.release();
    }
}
