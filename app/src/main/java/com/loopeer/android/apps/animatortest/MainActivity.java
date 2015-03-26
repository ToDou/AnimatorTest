package com.loopeer.android.apps.animatortest;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    private Button mButtonInterpolator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);

        mButtonInterpolator = (Button) findViewById(R.id.main_activity_interpolator);
        mButtonInterpolator.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_activity_interpolator:
                startActivity(new Intent(this, InterpolatorActivity.class));
        }
    }
}
