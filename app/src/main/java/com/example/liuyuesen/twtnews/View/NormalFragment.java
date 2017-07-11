package com.example.liuyuesen.twtnews.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liuyuesen.twtnews.R;
import com.example.liuyuesen.twtnews.presenter.NewsPresenter;
import com.example.liuyuesen.twtnews.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liuyuesen on 2017/7/6.
 */

public class NormalFragment extends Fragment {
    @BindView(R.id.normal_refresh)
    SwipeRefreshLayout water_refresh;
    @BindView(R.id.normal_recyclerView)
    RecyclerView waterfall_recyclerView;
    private WaterfallTableAdpater tableAdpater;
    private LinearLayoutManager layoutManager;
    private NewsBean newsBean = new NewsBean();
    Presenter presenter = new NewsPresenter(this);
    private  int  news = 1;
    private int page = 1;
    boolean isLoading = false;
    boolean isRefrashing = false;
    @BindView(R.id.normal_textView)
    TextView errorTextView ;

    public static NormalFragment newInstance(String string) {
        Bundle args = new Bundle();
        args.putString("index", string);
        NormalFragment normalFragment = new NormalFragment();
        normalFragment.setArguments(args);
        return normalFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInsanceState) {
        View view = inflater.inflate(R.layout.fragment_normal, container, false);
        ButterKnife.bind(this, view);
        //++news;
        layoutManager = new LinearLayoutManager(getContext());
//        layoutManager = (LinearLayoutManager) waterfall_recyclerView.getLayoutManager();
        //layoutManager = new LinearLayoutManager();
        waterfall_recyclerView.setLayoutManager(layoutManager);
        //presenter.getData(String.valueOf(news), String.valueOf(page));
        tableAdpater = new WaterfallTableAdpater(newsBean, getActivity());
        newsBean.data = new ArrayList<>();
        waterfall_recyclerView.setAdapter(tableAdpater);

        Bundle bundle = getArguments();
        final String newsString = bundle.getString("index");
        presenter.getData(newsString, String.valueOf(page));


        water_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                    isLoading = true;
                    page = 1;
                    newsBean.data.clear();
                    presenter.getData(newsString, String.valueOf(page));
            }
        });
        waterfall_recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int totalCount = layoutManager.getItemCount();
                int lastPositions;
                lastPositions = layoutManager.findLastVisibleItemPosition();
                Toast.makeText(getActivity(), "asdfdgds",Toast.LENGTH_SHORT).show();
                if ( (totalCount == lastPositions + 1 )&& isLoading == false) {
                    ++page;
                    isLoading = true;
                    presenter.getData(newsString, String.valueOf(page));

                }
            }
        });
        return view;

    }

//    public void showData(NewsBean newsBean) {
//        this.newsBean.data.addAll(newsBean.data);
//        tableAdpater.notifyDataSetChanged();
//        water_refresh.setRefreshing(false);
//        isLoading = false;
//    }
    private void onErrorBehavior(){
        isLoading = false;
        water_refresh.setRefreshing(false);
        waterfall_recyclerView.setVisibility(View.INVISIBLE);
    }

    private void onOkBehavior(){
        isLoading = false;
        water_refresh.setRefreshing(false);
        waterfall_recyclerView.setVisibility(View.VISIBLE);
    }


    public void showData(NewsBean newsBean) {
        this.newsBean.data.addAll(newsBean.data);
        if(newsBean.data.isEmpty()){
            Toast.makeText(getActivity(),"数据错误，请稍后重试",Toast.LENGTH_SHORT).show();
            onErrorBehavior();
        }
        else {
            tableAdpater.notifyDataSetChanged();
            onOkBehavior();
        }
    }

    public void onError() {
        onErrorBehavior();
        Toast.makeText(getActivity(),"网络错误,请检查网络",Toast.LENGTH_SHORT).show();
    }

    public void onDataError() {
        onErrorBehavior();
        errorTextView.setVisibility(View.VISIBLE);
        errorTextView.setText("数据错误，请稍后重试");
    }
}
