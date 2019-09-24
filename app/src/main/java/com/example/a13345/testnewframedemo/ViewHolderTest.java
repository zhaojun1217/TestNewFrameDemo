package com.example.a13345.testnewframedemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by zhaoj on 2019/5/18.
 */

class ViewHolderTest extends RecyclerView.ViewHolder {

    private TextView tvItemContent;

    public ViewHolderTest(View itemView) {
        super(itemView);
        tvItemContent = itemView.findViewById(R.id.tvItemContent);
    }

    public void initData(Context mContext, int position) {
        tvItemContent.setText("第" + (position + 1) + "行");
        if (position % 2 == 0) {
            itemView.setBackgroundColor(mContext.getResources().getColor(R.color.app_background));
        } else {
            itemView.setBackgroundColor(mContext.getResources().getColor(R.color.white ));
        }
    }
}
