package com.example.health_my.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.health_my.R;
import com.example.health_my.R2;
import com.example.health_my.adpater.Mycaixunadapter;
import com.example.health_my.presenter.IntePresenter;
import com.wd.common.bean.InteBase;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.common.util.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


@Route(path = Constant.ACTIVITY_URL_Int)
public class InterviewActivity extends WDActivity {
    @BindView(R2.id.imager3)
    ImageView imager3;

    @BindView(R2.id.login_iv)
    TextView loginIv;
    @BindView(R2.id.imagetss)
    ImageView imagetss;
    @BindView(R2.id.text_add1)
    TextView textAdd1;
    @BindView(R2.id.rll_vienna)
    RelativeLayout rllVienna;
    @BindView(R2.id.recy_view)
    RecyclerView recyView;
    @BindView(R2.id.rll_viennas)
    RelativeLayout rllViennas;
    private SharedPreferences sp;
    private String sessionId;
    private int id;
    private IntePresenter intePresenter;
    private LinearLayoutManager linearLayoutManager;
    private Mycaixunadapter mycaixunadapter;


    @Override
    protected int getLayoutId() {
        return R.layout.interview_layout;



    }

    @Override
    protected void initView() {
        sp = getSharedPreferences("login",MODE_PRIVATE);

        sessionId = sp.getString("sessionId", "");
        id = sp.getInt("Id", 0);

        intePresenter = new IntePresenter(new interview());
        intePresenter.reqeust(id, sessionId, 1, 5);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mycaixunadapter = new Mycaixunadapter(InterviewActivity.this);
        recyView.setAdapter(mycaixunadapter);
        recyView.setLayoutManager(linearLayoutManager);
        imager3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 finish();
            }
        });

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

  private   class interview implements DataCall<List<InteBase>> {


      @Override
      public void success(List<InteBase> data, Object... args) {
          Log.d("aaa", "success: "+data);


          if (data!=null) {

             /*  rllVienna.setVisibility(View.VISIBLE);
                rllViennas.setVisibility(View.GONE);*/
              mycaixunadapter.AddAll(data);
              mycaixunadapter.notifyDataSetChanged();
          } else if (data == null) {
              rllViennas.setVisibility(View.GONE);
              rllVienna.setVisibility(View.VISIBLE);


          }
      }

      @Override
      public void fail(ApiException data, Object... args) {

      }
  }
    }
