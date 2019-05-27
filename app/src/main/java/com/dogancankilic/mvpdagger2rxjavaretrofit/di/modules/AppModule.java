package com.dogancankilic.mvpdagger2rxjavaretrofit.di.modules;

import com.dogancankilic.mvpdagger2rxjavaretrofit.contract.IMvpContract;
import com.dogancankilic.mvpdagger2rxjavaretrofit.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final IMvpContract.View view;

    public AppModule(IMvpContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    IMvpContract.View provideView() {
        return view;
    }


}
