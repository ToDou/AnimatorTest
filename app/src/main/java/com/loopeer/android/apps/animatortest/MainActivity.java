package com.loopeer.android.apps.animatortest;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends ActionBarActivity{

    /*
    alpha
    rotation
    translationX
    translationY
    scaleX 缩放宽度
    scaleY  缩放高度
    pivotX 旋转的轴点和缩放的基准点
    pivotY 旋转的轴点和缩放的基准点
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        ButterKnife.inject(this);
    }

    @OnClick({
            R.id.main_activity_interpolator,
            R.id.main_activity_linear_menu,
            R.id.main_activity_value_animator,
            R.id.main_activity_edittext_animator
    })
    @SuppressWarnings("unused")
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_activity_interpolator:
                startActivity(new Intent(this, InterpolatorActivity.class));
                break;
            case R.id.main_activity_linear_menu:
                startActivity(new Intent(this, LinearMenuAnimatorTest.class));
                break;
            case R.id.main_activity_value_animator:
                startActivity(new Intent(this, ValueAnimatorTest.class));
                break;
            case R.id.main_activity_edittext_animator:
                startActivity(new Intent(this, EditTextAnimatorTest.class));
                break;
        }
    }
}
