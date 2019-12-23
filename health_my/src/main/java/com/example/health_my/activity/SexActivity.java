package com.example.health_my.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.health_my.R;
import com.example.health_my.R2;
import com.example.health_my.presenter.SexPresenter;
import com.wd.common.bean.Result;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SexActivity extends WDActivity {


    @BindView(R2.id.but_wc)
    Button butWc;
    @BindView(R2.id.boy_iv)
    ImageView boyIv;
    @BindView(R2.id.girl_iv)
    ImageView girlIv;
    @BindView(R2.id.iv_yes)
    ImageView ivYes;
    @BindView(R2.id.iv_no)
    ImageView ivNo;
    private SexPresenter sexPresenter;
    private SharedPreferences sp;
    private String sessionId;
    private int id;
    private int sex = 1;
    private int sexs = 2;
    private SharedPreferences.Editor edit;
    private PopupWindow popupWindow;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sex;
    }

    @Override
    protected void initView() {
        sp = getSharedPreferences("login", MODE_PRIVATE);
        sessionId = sp.getString("sessionId", "");
        id = sp.getInt("Id", 0);
        edit = sp.edit();
        edit.putInt("sexs",sex);
        edit.putInt("sexss",sexs);
        edit.commit();
        sexPresenter = new SexPresenter(new SexPresen());
        sexPresenter.reqeust(id, sessionId, 1);
        boyIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sexPresenter.reqeust(id, sessionId, 1);
                ivYes.setVisibility(View.VISIBLE);
                ivNo.setVisibility(View.GONE);
            }
        });
        girlIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sexPresenter.reqeust(id, sessionId, 2);
                ivYes.setVisibility(View.GONE);
                ivNo.setVisibility(View.VISIBLE);
            }
        });
        butWc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopWindow();
            }
        });
    }
    private void showPopWindow() {
        //找到pop弹窗布局
        View view = LayoutInflater.from(SexActivity.this).inflate(R.layout.pop_sex, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setContentView(view);
        //设置高度
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
        //找子布局控件
        TextView but = view.findViewById(R.id.pop_but);
        TextView qu = view.findViewById(R.id.pop_qu);
        //去咨询
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //取消
        qu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        //activity的布局
        View rootView = LayoutInflater.from(SexActivity.this).inflate(R.layout.activity_sex, null);
        //位置
        popupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);
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

    private class SexPresen implements DataCall<Result> {
        @Override
        public void success(Result data, Object... args) {
            Toast.makeText(SexActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void fail(ApiException data, Object... args) {
            Toast.makeText(SexActivity.this, "修改失败", Toast.LENGTH_SHORT).show();
        }
    }
}
