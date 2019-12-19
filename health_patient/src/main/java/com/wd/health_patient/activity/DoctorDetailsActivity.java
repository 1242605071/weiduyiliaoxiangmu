package com.wd.health_patient.activity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.bean.DetielBean;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.health_patient.R;
import com.wd.health_patient.R2;
import com.wd.health_patient.presenter.FindDoctorInfoPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoctorDetailsActivity extends WDActivity {


    @BindView(R2.id.jian)
    ImageView jian;
    @BindView(R2.id.login_iv)
    TextView loginIv;
    @BindView(R2.id.doctor_sim)
    SimpleDraweeView doctorSim;
    @BindView(R2.id.details_name)
    TextView detailsName;
    @BindView(R2.id.doctor_yishi)
    TextView doctorYishi;
    @BindView(R2.id.doctor_yuan)
    TextView doctorYuan;
    @BindView(R2.id.doctor_lv)
    TextView doctorLv;
    @BindView(R2.id.doctor_shu)
    TextView doctorShu;
    @BindView(R2.id.doctor_view)
    View doctorView;
    @BindView(R2.id.doctor_flower)
    ImageView doctorFlower;
    @BindView(R2.id.hua)
    TextView hua;
    @BindView(R2.id.doctor_flowe)
    ImageView doctorFlowe;
    @BindView(R2.id.shuben)
    TextView shuben;
    @BindView(R2.id.doctor_flow)
    ImageView doctorFlow;
    @BindView(R2.id.jiangbei)
    TextView jiangbei;
    @BindView(R2.id.doctor_v)
    View doctorV;
    @BindView(R2.id.jianli)
    TextView jianli;
    @BindView(R2.id.doctor_vt)
    View doctorVt;
    @BindView(R2.id.jianl)
    TextView jianl;
    @BindView(R2.id.doctor_vtt)
    View doctorVtt;
    @BindView(R2.id.rv_doctor)
    RecyclerView rvDoctor;
    @BindView(R2.id.hbi)
    TextView hbi;
    @BindView(R2.id.tiaozhuan)
    TextView tiaozhuan;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_doctor_details;
    }

    @Override
    protected void initView() {
        FindDoctorInfoPresenter findDoctorInfoPresenter = new FindDoctorInfoPresenter(new Find());
        SharedPreferences iddo = getSharedPreferences("iddd", MODE_PRIVATE);
        int anInt = iddo.getInt("key", 0);
        findDoctorInfoPresenter.reqeust(anInt);
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

    private class Find implements DataCall <DetielBean> {
        @Override
        public void success(DetielBean data, Object... args) {
                doctorSim.setImageURI(data.imagePic);
                detailsName.setText(data.doctorName);
                doctorYishi.setText(data.jobTitle);
                doctorYuan.setText(data.inauguralHospital);
                doctorLv.setText("好评率 "+data.praise);
                doctorShu.setText("服务患者数 "+data.serverNum);
                jianli.setText(data.personalProfile);
                jianl.setText(data.goodField);
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
