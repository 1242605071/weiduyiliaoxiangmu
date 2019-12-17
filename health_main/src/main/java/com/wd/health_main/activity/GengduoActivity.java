package com.wd.health_main.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.common.bean.XiangqingBase;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.health_main.R;
import com.wd.health_main.R2;
import com.wd.health_main.adapter.InformationAdapter;
import com.wd.health_main.presenter.FindDepartmentPresenter;
import com.wd.health_main.presenter.XiangqingPresenter;
import com.wd.health_main.presenter.XiangqingPresenters;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GengduoActivity extends WDActivity implements XRecyclerView.LoadingListener {
    @BindView(R2.id.xrecycler_view)
    XRecyclerView xrecyclerView;
    @BindView(R2.id.text_names)
    TextView textNames;
    private FindDepartmentPresenter findDepartmentPresenter;
    private XiangqingPresenters xiangqingPresenter;
    private InformationAdapter informationAdapter;
    private SharedPreferences sp;
    private int id;
    private String name;

    @Override
    protected int getLayoutId() {
        return R.layout.gengduo_layout;
    }

    @Override
    protected void initView() {
        sp = getSharedPreferences("xiang", MODE_PRIVATE);
        id = sp.getInt("Id", 0);
        name = sp.getString("Name", "");
        textNames.setText(name);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(GengduoActivity.this);

        linearLayoutManager.setOrientation(xrecyclerView.VERTICAL);
        xrecyclerView.setLayoutManager(linearLayoutManager);


        informationAdapter = new InformationAdapter(GengduoActivity.this);
        xrecyclerView.setAdapter(informationAdapter);
        xrecyclerView.setLoadingListener(this);
        xiangqingPresenter = new XiangqingPresenters(new gengduo());
        xiangqingPresenter.reqeust(id,true);

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

    @Override
    public void onRefresh() {
        xiangqingPresenter.reqeust(id,true);
    }

    @Override
    public void onLoadMore() {
        xiangqingPresenter.reqeust(id,false);
    }


    class gengduo implements DataCall<List<XiangqingBase>> {

        @Override
        public void success(List<XiangqingBase> data, Object... args) {
            Log.d("aaa1", "success: " + data);
            xrecyclerView.refreshComplete();
            xrecyclerView.loadMoreComplete();
            if (xiangqingPresenter.getPage() == 1){//页面为1则为刷新
                informationAdapter.clear();
            }

            informationAdapter.addAll(data);
            informationAdapter.notifyDataSetChanged();

        }

        @Override
        public void fail(ApiException data, Object... args) {
            xrecyclerView.refreshComplete();
            xrecyclerView.loadMoreComplete();
        }
    }
}
