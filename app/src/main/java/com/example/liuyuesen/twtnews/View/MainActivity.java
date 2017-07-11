package com.example.liuyuesen.twtnews.View;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.TableLayout;

import com.example.liuyuesen.twtnews.R;
import com.example.liuyuesen.twtnews.presenter.NewsPresenter;
import com.example.liuyuesen.twtnews.presenter.Presenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BaseActivity {
    @BindView(R.id.news_viewPager)
    ViewPager viewPager;
    @BindView(R.id.news_tabLayout)
     TabLayout tabLayout;

    String[] strArray={"天大要闻","校园公告","社团风采","院系动态","视点观察"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        WaterfallPagerAdapter pagerAdapter = new WaterfallPagerAdapter(getSupportFragmentManager());
        for (int i=0;i<5;i++){
            pagerAdapter.add(NormalFragment.newInstance(String.valueOf(i+1)),strArray[i]);
        }
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(Gravity.FILL);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#00a1e9"));

    }

}
