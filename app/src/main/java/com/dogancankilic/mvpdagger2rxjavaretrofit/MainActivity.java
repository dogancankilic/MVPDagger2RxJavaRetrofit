package com.dogancankilic.mvpdagger2rxjavaretrofit;

import android.os.Bundle;
import android.view.Display;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dogancankilic.mvpdagger2rxjavaretrofit.adapter.RVAdapter;
import com.dogancankilic.mvpdagger2rxjavaretrofit.contract.IMvpContract;
import com.dogancankilic.mvpdagger2rxjavaretrofit.di.App;
import com.dogancankilic.mvpdagger2rxjavaretrofit.di.components.DaggerAppComponent;
import com.dogancankilic.mvpdagger2rxjavaretrofit.di.modules.AppModule;
import com.dogancankilic.mvpdagger2rxjavaretrofit.model.Model;
import com.dogancankilic.mvpdagger2rxjavaretrofit.presenter.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMvpContract.View {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    private RVAdapter adapter;

    @Inject
    BasePresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DaggerAppComponent.builder()
                .networkComponent(((App) getApplication()).getNetComponent())
                .appModule(new AppModule(this))
                .build().inject(this);
        presenter.start();

    }

    @Override
    public void loadImages(List<Model> list) {
        adapter = new RVAdapter(this,list);
        recyclerview.setAdapter(adapter);


    }

    @Override
    public void init() {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        recyclerview.setLayoutManager(gridLayoutManager);
        presenter.loadPhotos();

    }

    @Override
    public void showError(String e) {
        Toast.makeText(this, e, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {

        Toast.makeText(this, "Completed", Toast.LENGTH_SHORT).show();

    }
}
