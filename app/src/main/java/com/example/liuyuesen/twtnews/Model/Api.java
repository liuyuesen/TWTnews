package com.example.liuyuesen.twtnews.Model;

import com.example.liuyuesen.twtnews.View.NewsBean;

/**
 * Created by liuyuesen on 2017/7/7.
 */

public interface Api {
    /**
     * Created by liuyuesen on 2017/7/7.
     */
    void getData(String news, String page);

    void showData(NewsBean newsbean);

    void onError();
}
