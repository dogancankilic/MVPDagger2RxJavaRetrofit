package com.dogancankilic.mvpdagger2rxjavaretrofit.di.components;

import com.dogancankilic.mvpdagger2rxjavaretrofit.MainActivity;
import com.dogancankilic.mvpdagger2rxjavaretrofit.di.scopes.ActivityScope;
import com.dogancankilic.mvpdagger2rxjavaretrofit.di.modules.AppModule;


import dagger.Component;


@ActivityScope
@Component(dependencies = NetworkComponent.class, modules = {AppModule.class})
public interface AppComponent {

    void inject(MainActivity activity);


}
