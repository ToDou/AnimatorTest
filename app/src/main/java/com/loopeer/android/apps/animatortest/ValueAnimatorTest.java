package com.loopeer.android.apps.animatortest;

import android.animation.IntEvaluator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.ViewHelper;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by tudou on 15-3-27.
 */
public class ValueAnimatorTest extends BaseActivity {

    @InjectView(R.id.text_value_animator_activity)
    TextView mTextValueAnimator;
    @InjectView(R.id.btn_value_animator_activity)
    Button mBtnValueAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valueanimator);
        ButterKnife.inject(this);
    }

    @OnClick({
            R.id.btn_value_animator_activity
    })
    @SuppressWarnings("unused")
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.btn_value_animator_activity:
                startTextValueAnimator();
//                startButtonAnimator();
                startButtonValueAnimator(mBtnValueAnimator, mBtnValueAnimator.getWidth(), ValueAnimatorTest.this.getResources().getDisplayMetrics().widthPixels);
                break;
        }
    }

    private void startButtonAnimator() {
        final int width = mBtnValueAnimator.getWidth();
        ViewWrapper viewWrapper = new ViewWrapper(mBtnValueAnimator);
        ObjectAnimator obj = ObjectAnimator.ofInt(viewWrapper, "width", width, ValueAnimatorTest.this.getResources().getDisplayMetrics().widthPixels).setDuration(1000);
        obj.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mBtnValueAnimator.getLayoutParams().width = width;
                mBtnValueAnimator.requestLayout();
            }
        });
        obj.start();
    }

    private void startButtonValueAnimator(final View target, final int start, final int end) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(1, 100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();
                float fraction = currentValue / 100f;
                target.getLayoutParams().width = (int) (start + ((end - start) * fraction));
                target.requestLayout();
            }
        });

        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                target.getLayoutParams().width = start;
            }
        });

        valueAnimator.setDuration(5000).start();
    }

    private void startTextValueAnimator() {
        float layoutY = ViewHelper.getY(mTextValueAnimator);
        mTextValueAnimator.setVisibility(View.VISIBLE);
        ObjectAnimator.ofFloat(mTextValueAnimator, "Y", layoutY + mTextValueAnimator.getHeight(), layoutY).setDuration(500).start();
    }

    private static class ViewWrapper {
        private View mTarget;

        public ViewWrapper (View view) {
            mTarget = view;
        }

        public int getWidth() {
            return mTarget.getLayoutParams().width;
        }

        public void setWidth(int width) {
            mTarget.getLayoutParams().width = width;
            mTarget.requestLayout();
        }
    }
}
