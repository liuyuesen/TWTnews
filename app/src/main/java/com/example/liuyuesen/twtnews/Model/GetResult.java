package com.example.liuyuesen.twtnews.Model;

import com.example.liuyuesen.twtnews.View.NewsBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by liuyuesen on 2017/7/7.
 */

public interface GetResult {
    @GET("api/v1/news/{news}/page/{page}")
    Call<NewsBean> getCall(@Path("news") String news, @Path("page") String page) ;
}
