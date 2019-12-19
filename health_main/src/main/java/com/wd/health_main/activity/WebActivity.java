package com.wd.health_main.activity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wd.common.core.WDActivity;
import com.wd.common.util.Constant;
import com.wd.health_main.R;
import com.wd.health_main.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
@Route(path = Constant.ACTIVITY_URL_Web)
public class WebActivity extends WDActivity {
    @BindView(R2.id.webview)
    WebView webview;
    private WebSettings settings;

    @Override
    protected int getLayoutId() {
        return R.layout.web_layout;
    }

    @Override
    protected void initView() {
        settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);

        String str ="https://www.wjx.cn/jq/33939807.aspx";
        webview.loadUrl(str);

    }

    @Override
    protected void destoryData() {

    }


}
