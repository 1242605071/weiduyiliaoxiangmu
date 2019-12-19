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

import com.example.health_my.R;
import com.example.health_my.R2;
import com.example.health_my.adpater.TrailerFragmentAdapter;
import com.example.health_my.presenter.VideoPresenter;
import com.wd.common.bean.Video;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoActivity extends WDActivity {
    @BindView(R2.id.imagerr)
    ImageView imagerr;
    @BindView(R2.id.video_tv)
    TextView videoTv;
    @BindView(R2.id.tlv_video)
    RelativeLayout tlvVideo;
    @BindView(R2.id.video_rlv)
    RecyclerView videoRlv;
    @BindView(R2.id.text_videos)
    RelativeLayout textVideos;
    private SharedPreferences sp;
    private String sessionId;
    private int id;
    private VideoPresenter videoPresenter;
    private TrailerFragmentAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected int getLayoutId() {
        return R.layout.video_layout;

    }

    @Override
    protected void initView() {
      /*  sp = getSharedPreferences("login",MODE_PRIVATE);
        sessionId = sp.getString("sessionId", "");
        id = sp.getInt("Id", 0);

        videoPresenter = new VideoPresenter(new VideoPresen1());
        videoPresenter.reqeust(id,sessionId,1,5);

        adapter = new TrailerFragmentAdapter(this);

        videoRlv.setAdapter(adapter);
        linearLayoutManager = new LinearLayoutManager(this);

        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        videoRlv.setLayoutManager(linearLayoutManager);   */

        sp = getSharedPreferences("login", MODE_PRIVATE);
        sessionId = sp.getString("sessionId", "");
        id = sp.getInt("Id", 0);
        videoPresenter = new VideoPresenter(new VideoPresen1());
        videoPresenter.reqeust(id,sessionId,1,5);

        adapter = new TrailerFragmentAdapter(this);

         videoRlv.setAdapter(adapter);
        linearLayoutManager = new LinearLayoutManager(this);
          linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
          videoRlv.setLayoutManager(linearLayoutManager);

    }

    @Override
    protected void destoryData() {

    }

    private class VideoPresen1 implements DataCall<List<Video>> {

        private String title;

        @Override
        public void success(List<Video> data, Object... args) {
            Log.d("aaa", "success: " + data);
            for (int i = 0; i < data.size(); i++) {
                title = data.get(i).title;
            }

             if (title!=null){
                 tlvVideo.setVisibility(View.GONE);
                 textVideos.setVisibility(View.VISIBLE);
                 adapter.addAll(data);
                 adapter.notifyDataSetChanged();
             }else if (title ==null){
                 tlvVideo.setVisibility(View.VISIBLE);
                 textVideos.setVisibility(View.GONE);
             }

        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
    }
