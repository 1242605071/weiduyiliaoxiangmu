package com.wd.health_patient.presenter;

import com.wd.common.core.DataCall;
import com.wd.common.core.WDPresenter;
import com.wd.common.core.http.IAppRequest;

import io.reactivex.Observable;

/**
 * @Description: 作用描述
 * @CreateDate: 2019/12/17 8:34
 * @Author: 作者名
 * @Version: 1.0
 */
public class FindDoctorInfoPresenter extends WDPresenter<IAppRequest> {

    public FindDoctorInfoPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Object... args) {
        return iRequest.findDoctorInfo((int)args[0]);
    }
}
