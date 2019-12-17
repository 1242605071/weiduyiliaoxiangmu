package com.wd.health_main.presenter;

import com.wd.common.core.DataCall;
import com.wd.common.core.WDPresenter;
import com.wd.common.core.http.IAppRequest;

import io.reactivex.Observable;

public class XiangqingPresenters extends WDPresenter<IAppRequest> {
    private int page;
    public XiangqingPresenters(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Object... args) {
        boolean isRefresh = (boolean) args[1];
        if (isRefresh) {
             page=1;
        }else {
             page++;
        }
        return iRequest.xiangqingzixun((int)args[0],page,5);
    }

    public int getPage() {
        return page;
    }
}
