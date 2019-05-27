package com.dogancankilic.mvpdagger2rxjavaretrofit.contract;

import com.dogancankilic.mvpdagger2rxjavaretrofit.model.Model;

import java.util.ArrayList;
import java.util.List;

public interface IMvpContract {


    interface Presenter{
        void start();
        void loadPhotos();

    }

    interface View {

        void loadImages(List<Model> list);
        void init();
        void showError(String e);
        void showComplete();

    }
}
