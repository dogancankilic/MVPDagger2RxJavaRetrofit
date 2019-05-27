package com.dogancankilic.mvpdagger2rxjavaretrofit.presenter;


import com.dogancankilic.mvpdagger2rxjavaretrofit.contract.IMvpContract;
import com.dogancankilic.mvpdagger2rxjavaretrofit.model.Model;
import com.dogancankilic.mvpdagger2rxjavaretrofit.network.NetworkService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class BasePresenter implements IMvpContract.Presenter {

    Retrofit retrofit;
    IMvpContract.View view;

    @Inject
    public BasePresenter(Retrofit retrofit, IMvpContract.View view) {
        this.retrofit = retrofit;
        this.view = view;
    }

    @Override
    public void start() {
        view.init();

    }

    @Override
    public void loadPhotos() {

        retrofit.create(NetworkService.class).getModel()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Model>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Model> models) {
                        view.loadImages(models);

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        view.showComplete();

                    }
                });

    }
}
