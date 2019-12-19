package com.example.health_my.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.health_my.R;
import com.example.health_my.R2;
import com.wd.common.core.WDActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MineActivity extends WDActivity {




    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void destoryData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
