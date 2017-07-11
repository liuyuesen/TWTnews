package com.example.liuyuesen.twtnews.Model;

import com.example.liuyuesen.twtnews.View.NewsBean;
import com.example.liuyuesen.twtnews.presenter.NewsPresenter;
import com.example.liuyuesen.twtnews.presenter.Presenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liuyuesen on 2017/7/7.
 */

public class ApiClient implements Api {
    public Presenter presenter;

    //http://open.twtstudio.com/api/v1/news/1/page/1
    public ApiClient(NewsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getData(String news, String page) {
        //建立retrofit实例
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://open.twtstudio.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetResult result = retrofit.create(GetResult.class);

        Call<NewsBean> call = result.getCall(news, page);

        call.enqueue(new Callback<NewsBean>() {
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                if (response.isSuccessful()){
                    showData(response.body());
                }
                else{
                    onDataError();
                }
            }

            @Override
            public void onFailure(Call<NewsBean> call, Throwable t) {
                onError();
            }
        });
    }

    @Override
    public void showData(NewsBean newsBean) {
        presenter.showData(newsBean);
    }

    public void onError(){
        presenter.onError();
    }

    public void onDataError(){
        presenter.onDataError();
    }
}
