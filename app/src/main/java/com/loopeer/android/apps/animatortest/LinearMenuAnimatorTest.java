package com.loopeer.android.apps.animatortest;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

import com.nineoldandroids.animation.ObjectAnimator;

/**
 * Created by tudou on 15-3-27.
 */
public class LinearMenuAnimatorTest extends BaseActivity implements View.OnClickListener {

    private int[] mIconId = new int[]{R.id.icon_menu_item1, R.id.icon_menu_item2, R.id.icon_menu_item3, R.id.icon_menu_item4,
        R.id.icon_menu_item5, R.id.icon_menu_item6, R.id.icon_menu_item7};

    private ImageView[] mIcons = new ImageView[7];
    private ImageView mImageMenu;

    private boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_menu);

        mImageMenu = (ImageView) this.findViewById(R.id.icon_menu_main);
        mImageMenu.setOnClickListener(this);

        for (int i = 0; i < mIconId.length; i++) {
            mIcons[i] = (ImageView) LinearMenuAnimatorTest.this.findViewById(mIconId[i]);
            mIcons[i].setOnClickListener(LinearMenuAnimatorTest.this);
        }
        initImages();
    }

    private void initImages() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.icon_menu_main:
                if (!isOpen) {
                    openMenu();
                } else {
                    closeMenu();
                }
                break;
            default:

                break;
        }
    }

    private void closeMenu() {
        ObjectAnimator.ofFloat(mImageMenu, "rotation", 90F, 0F).setDuration(500).start();
        for (int i = 0; i < mIcons.length; i++) {
            ObjectAnimator obj = ObjectAnimator.ofFloat(mIcons[i], "translationY", - 150 * (i + 1), 0f);
            obj.setDuration(500);
            obj.setInterpolator(new AccelerateDecelerateInterpolator());
            obj.setStartDelay((i + 1) * 300);
            obj.start();

        }
        isOpen = false;
    }

    private void openMenu() {
        ObjectAnimator.ofFloat(mImageMenu, "rotation", 0F, 90F).setDuration(500).start();
        for (int i = 0; i < mIcons.length; i++) {
            ObjectAnimator obj = ObjectAnimator.ofFloat(mIcons[i], "translationY", 0f, - 160 * (i + 1));
            obj.setDuration(500);
            obj.setInterpolator(new BounceInterpolator());
            obj.setStartDelay((i+ 1) *300);
            obj.start();

        }
        isOpen = true;
    }
}
