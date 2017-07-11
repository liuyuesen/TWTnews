package com.example.liuyuesen.twtnews.presenter;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.example.liuyuesen.twtnews.Model.Api;
import com.example.liuyuesen.twtnews.Model.ApiClient;
import com.example.liuyuesen.twtnews.View.BaseActivity;
import com.example.liuyuesen.twtnews.View.NewsBean;
import com.example.liuyuesen.twtnews.View.NormalFragment;
import com.example.liuyuesen.twtnews.View.WaterfallFragment;

/**
 * Created by liuyuesen on 2017/7/7.
 */

public class NewsPresenter implements Presenter {
    NormalFragment fragment;
    Api api;

    public NewsPresenter (NormalFragment fragment){
        this.fragment = fragment;
    }


    @Override
    public void getData(String news,String page) {
        api = new ApiClient(this);
        api.getData(news,page);
    }

    @Override
    public void showData(NewsBean newsBean) {
        fragment.showData(newsBean);
    }
    @Override
    public void onError (){
        fragment.onError();
    }

    @Override
    public void onDataError(){
        fragment.onDataError();
    }
}
