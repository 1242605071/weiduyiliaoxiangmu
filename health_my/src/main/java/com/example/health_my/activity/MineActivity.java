package com.example.health_my.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.health_my.R;
import com.example.health_my.R2;
import com.example.health_my.presenter.LoginPresenter;
import com.wd.common.bean.Login;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;

import java.net.URI;
import java.net.URISyntaxException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MineActivity extends WDActivity {


    @BindView(R2.id.set_up_iv)
    ImageView setUpIv;
    @BindView(R2.id.set_up_sex)
    RelativeLayout setUpSex;
    @BindView(R2.id.set_up_ivs)
    ImageView setUpIvs;
    @BindView(R2.id.set_up_activity_tv_iv)
    ImageView setUpActivityTvIv;
    @BindView(R2.id.set_up_name)
    TextView setUpName;
    @BindView(R2.id.set_up_email)
    TextView setUpEmail;
    private LoginPresenter loginPresenter;
    private SharedPreferences sp;
    private String pwds;
    private String email;
    private String nickName;
    private String headPic;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine;
    }

    @Override
    protected void initView() {
        setUpSex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(SexActivity.class);
            }
        });
        sp = getSharedPreferences("login", MODE_PRIVATE);
        email = sp.getString("email", "");
        pwds = sp.getString("pwds", "");
        nickName = sp.getString("nickName", "");
        headPic = sp.getString("headPic", "");


        setUpEmail.setText(email);
        setUpName.setText(nickName);
        Glide.with(this).load(headPic).into(setUpActivityTvIv);
        loginPresenter = new LoginPresenter(new LoginPresens());

    }

    @Override
    protected void onResume() {
        super.onResume();
        loginPresenter.reqeust(email,pwds);
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

    private class LoginPresens implements DataCall<Login> {
        @Override
        public void success(Login data, Object... args) {
            if (data.sex == 1) {
                setUpIv.setVisibility(View.VISIBLE);
                setUpIvs.setVisibility(View.GONE);
            } else if (data.sex == 2) {
                setUpIvs.setVisibility(View.VISIBLE);
                setUpIv.setVisibility(View.GONE);
            }
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
