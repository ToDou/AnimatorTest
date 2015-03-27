package com.loopeer.android.apps.animatortest;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by tudou on 15-3-27.
 */
public class EditTextAnimatorTest extends BaseActivity {

    @InjectView(R.id.layout_edittext_animator_area)
    LinearLayout mLayoutEditArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext_animator);
        ButterKnife.inject(this);
    }

    @OnClick({
            R.id.btn_edittext_animator_submit
    })
    @SuppressWarnings("unused")
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_edittext_animator_submit:
                showShakeAnimator();
                break;
        }
    }

    private void showShakeAnimator() {
        /*

                ObjectAnimator.ofFloat(mLayoutEditArea,"scaleX",1,0.9f,0.9f,1.1f,1.1f,1.1f,1.1f,1.1f,1.1f,1),
                ObjectAnimator.ofFloat(mLayoutEditArea,"scaleY",1,0.9f,0.9f,1.1f,1.1f,1.1f,1.1f,1.1f,1.1f,1),
                ObjectAnimator.ofFloat(mLayoutEditArea, "rotation", 0, 3, 3, -3, -3, 3, 3, -3, -3, 0)
         */

        AnimatorSet animators = new AnimatorSet();
        animators.playTogether(
                ObjectAnimator.ofFloat(mLayoutEditArea,"pivotX", 16, 16)
        );
        animators.start();
    }

}
