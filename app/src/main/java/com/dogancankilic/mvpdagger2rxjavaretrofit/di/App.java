package com.dogancankilic.mvpdagger2rxjavaretrofit.di;

import android.app.Application;

import com.dogancankilic.mvpdagger2rxjavaretrofit.Constants;
import com.dogancankilic.mvpdagger2rxjavaretrofit.di.components.DaggerNetworkComponent;
import com.dogancankilic.mvpdagger2rxjavaretrofit.di.components.NetworkComponent;
import com.dogancankilic.mvpdagger2rxjavaretrofit.di.modules.NetworkModule;

public class App extends Application {

    NetworkComponent netComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Constants.BASE_URL))
                .build();
    }

    public NetworkComponent getNetComponent(){
        return netComponent;
    }
}
