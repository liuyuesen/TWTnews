package com.example.liuyuesen.twtnews.View;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyuesen on 2017/7/6.
 */

public class WaterfallPagerAdapter extends FragmentPagerAdapter {

    public List<Fragment> waterfallFragmentList = new ArrayList<>();
    public List<String> titleList = new ArrayList<>();

    WaterfallPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return waterfallFragmentList.get(position);
    }

    public void add(Fragment fragment, String title) {
        waterfallFragmentList.add(fragment);
        titleList.add(title);
    }

    @Override
    public int getCount() {
        return waterfallFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

}

