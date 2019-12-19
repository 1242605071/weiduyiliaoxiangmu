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
import com.example.health_my.adpater.MyBingadapter;
import com.example.health_my.presenter.ByqPresenter;
import com.wd.common.bean.ByqBase;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.common.util.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = Constant.ACTIVITY_URL_Beng)
public class BingyouActivity extends WDActivity {

    @BindView(R2.id.jian)
    ImageView jian;
    @BindView(R2.id.login_iv)
    TextView loginIv;
    @BindView(R2.id.text_tv)
    TextView textTv;
    @BindView(R2.id.text_add)
    TextView textAdd;
    @BindView(R2.id.re_add)
    RelativeLayout reAdd;
    @BindView(R2.id.re_view)
    RecyclerView reView;
    @BindView(R2.id.re_bing)
    RelativeLayout reBing;
    private ByqPresenter byqPresenter;
    private SharedPreferences sp;
    private String sessionId;
    private int id;
    private MyBingadapter myBingadapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected int getLayoutId() {

        return R.layout.bing_layout;
    }

    @Override
    protected void initView() {
        textAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 reAdd.setVisibility(View.GONE);
                 reBing.setVisibility(View.VISIBLE);
            }
        });
        byqPresenter = new ByqPresenter(new byq());
        /*  sp = getSharedPreferences("login", MODE_PRIVATE);
        sessionId = sp.getString("sessionId", "");
        id = sp.getInt("Id", 0);*/
        sp = getSharedPreferences("login", MODE_PRIVATE);
        sessionId = sp.getString("sessionId", "");
        id = sp.getInt("Id", 0);
        byqPresenter.reqeust(id, sessionId, 1, 5);
        /*  adapter = new TrailerFragmentAdapter(this);
          videoRlv.setAdapter(adapter);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        videoRlv.setLayoutManager(linearLayoutManager);*/

        myBingadapter = new MyBingadapter(this);
        reView.setAdapter(myBingadapter);
        linearLayoutManager = new LinearLayoutManager(this);
        reView.setLayoutManager(linearLayoutManager);



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


    class byq implements DataCall<List<ByqBase>> {

        @Override
        public void success(List<ByqBase> data, Object... args) {
            Log.d("aaa", "success: " + data);
            myBingadapter.AddAll(data);
            myBingadapter.notifyDataSetChanged();


        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
