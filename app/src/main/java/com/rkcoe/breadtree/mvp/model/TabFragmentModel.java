package com.rkcoe.breadtree.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BaseModel;
import com.rkcoe.breadtree.mvp.contract.TabFragmentContract;
import com.rkcoe.breadtree.mvp.model.api.cache.CacheManager;
import com.rkcoe.breadtree.mvp.model.api.service.ServiceManager;

import javax.inject.Inject;

/**
 * Created by rkcoe on 2017/4/11.
 */

@ActivityScope
public class TabFragmentModel extends BaseModel<ServiceManager, CacheManager> implements TabFragmentContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public TabFragmentModel(ServiceManager serviceManager, CacheManager cacheManager, Gson gson, Application application) {
        super(serviceManager, cacheManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

}