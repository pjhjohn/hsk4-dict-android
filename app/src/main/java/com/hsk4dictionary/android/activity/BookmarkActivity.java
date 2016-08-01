package com.hsk4dictionary.android.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.hsk4dictionary.android.R;
import com.hsk4dictionary.android.utils.adapter.MyAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookmarkActivity extends Activity{
    @BindView(R.id.my_recycler_view) RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        String[] myDataset = {
            "aaa","bbb","ccc"
        };

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
}