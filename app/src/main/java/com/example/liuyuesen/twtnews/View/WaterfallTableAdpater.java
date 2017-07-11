package com.example.liuyuesen.twtnews.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.liuyuesen.twtnews.R;
import com.example.liuyuesen.twtnews.View.NewsBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liuyuesen on 2017/7/6.
 */

public class WaterfallTableAdpater extends RecyclerView.Adapter {
    Context context;
    NewsBean newsBean;

    public WaterfallTableAdpater(NewsBean newsBean, Context context) {
        this.newsBean = newsBean;
        this.context = context;
    }

    public class WaterfallViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_tv_title)
        TextView title;
        @BindView(R.id.item_tv_content)
        TextView content;
        public WaterfallViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new WaterfallViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (newsBean.data.size()!=0){
            NewsBean.DataBean dataBean = newsBean.data.get(position);
            WaterfallViewHolder viewHolder = (WaterfallViewHolder) holder;
            viewHolder.title.setText(dataBean.subject);
           // viewHolder.content.setText(dataBean.comments);
//        viewHolder.itemView.setOnClickListener(view -> {
//            startDetailActivity(dataBean.id);
//        });
        }
    }

    @Override
    public int getItemCount() {
        return newsBean.data.size();
    }
}
