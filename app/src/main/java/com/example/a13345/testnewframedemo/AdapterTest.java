package com.example.a13345.testnewframedemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by zhaoj on 2019/5/18.
 */

public class AdapterTest extends RecyclerView.Adapter<ViewHolderTest> {

    private Context mContext;

    public AdapterTest(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public ViewHolderTest onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderTest(LayoutInflater.from(mContext).inflate(R.layout.item_view,null));
    }

    @Override
    public void onBindViewHolder(ViewHolderTest holder, int position) {
        holder.initData(mContext,position);
    }

    @Override
    public int getItemCount() {
        return 22;
    }
}
