package com.rkcoe.breadtree.mvp.ui.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jess.arms.utils.UiUtils;
import com.rkcoe.breadtree.R;
import com.rkcoe.breadtree.di.module.TabFragmentModule;
import com.rkcoe.breadtree.mvp.contract.TabFragmentContract;
import com.rkcoe.breadtree.mvp.presenter.TabFragmentPresenter;

import common.AppComponent;
import common.WEFragment;

import static com.jess.arms.utils.Preconditions.checkNotNull;

/**
 * Created by rkcoe on 2017/4/11.
 */

public class TabFragmentFragment extends WEFragment<TabFragmentPresenter> implements TabFragmentContract.View {


    public static TabFragmentFragment newInstance() {
        TabFragmentFragment fragment = new TabFragmentFragment();
        return fragment;
    }

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {
        DaggerTabFragmentComponent
                .builder()
                .appComponent(appComponent)
                .tabFragmentModule(new TabFragmentModule(this))//请将TabFragmentModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    protected void initData() {

    }

    /**
     * 此方法是让外部调用使fragment做一些操作的,比如说外部的activity想让fragment对象执行一些方法,
     * 建议在有多个需要让外界调用的方法时,统一传bundle,里面存一个what字段,来区分不同的方法,在setData
     * 方法中就可以switch做不同的操作,这样就可以用统一的入口方法做不同的事,和message同理
     * <p>
     * 使用此方法时请注意调用时fragment的生命周期,如果调用此setData方法时onActivityCreated
     * 还没执行,setData里调用presenter的方法时,是会报空的,因为dagger注入是在onActivityCreated
     * 方法中执行的,如果要做一些初始化操作,可以不必让外部调setData,在内部onActivityCreated中
     * 初始化就可以了
     *
     * @param data
     */

    @Override
    public void setData(Object data) {

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        UiUtils.SnackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        UiUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {

    }

}