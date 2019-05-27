package com.dogancankilic.mvpdagger2rxjavaretrofit.network;

import com.dogancankilic.mvpdagger2rxjavaretrofit.model.Model;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NetworkService {

    @GET("photos")
    Observable<List<Model>> getModel();
}
