package com.example.liuyuesen.twtnews.presenter;

import com.example.liuyuesen.twtnews.View.NewsBean;

/**
 * Created by liuyuesen on 2017/7/7.
 */

public interface Presenter {

    public void getData(String news,String page);

    public void showData(NewsBean newsBean);

    public void onError();

    public void onDataError();
}
