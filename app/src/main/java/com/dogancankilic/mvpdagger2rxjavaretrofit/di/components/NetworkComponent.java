package com.dogancankilic.mvpdagger2rxjavaretrofit.di.components;


import com.dogancankilic.mvpdagger2rxjavaretrofit.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = NetworkModule.class)
public interface NetworkComponent {

    Retrofit retrofit();
}
