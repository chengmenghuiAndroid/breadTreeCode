package com.rkcoe.breadtree.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.rkcoe.breadtree.mvp.contract.TabFragmentContract;
import com.rkcoe.breadtree.mvp.model.TabFragmentModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rkcoe on 2017/4/11.
 */

@Module
public class TabFragmentModule {
    private TabFragmentContract.View view;

    /**
     * 构建TabFragmentModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public TabFragmentModule(TabFragmentContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    TabFragmentContract.View provideTabFragmentView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    TabFragmentContract.Model provideTabFragmentModel(TabFragmentModel model) {
        return model;
    }
}