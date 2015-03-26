package com.loopeer.android.apps.animatortest;

import android.animation.ValueAnimator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.nineoldandroids.animation.ObjectAnimator;


public class MainActivity extends ActionBarActivity {

    private Spinner mSpinner;
    private ImageView mTextView;
    private String[] interpolatorName = new String[]{"accelerate", "decelerate", "accelerate/decelerate", "anticipate", "overshoot", "anticipate/overshoot", "bounce"};

    private Interpolator[] interpolators = new Interpolator[]{new AccelerateInterpolator(),
        new DecelerateInterpolator(), new AccelerateDecelerateInterpolator(), new AnticipateInterpolator(),
            new OvershootInterpolator(), new AnticipateOvershootInterpolator(), new BounceInterpolator()};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpinner = (Spinner) this.findViewById(R.id.main_spinner);
        mTextView = (ImageView) this.findViewById(R.id.main_text);
        intSpinner();
    }

    private void intSpinner() {
        mSpinner.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, interpolatorName));
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                addAnimator(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void addAnimator(int position) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTextView, "X", 0F, 300F);
        objectAnimator.setDuration(2000);
        objectAnimator.setInterpolator(interpolators[position]);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(com.nineoldandroids.animation.ValueAnimator.RESTART);
        objectAnimator.start();
    }

    public void viewClick(View view) {
       // ObjectAnimator.ofFloat(mTextView, "translationX", 0.0F, 300.0F).setDuration(4000).start();
        ObjectAnimator.ofFloat(mTextView, "rotationX", 0.0F, 360.0F)//
                .setDuration(500)//
                .start();

    }


}