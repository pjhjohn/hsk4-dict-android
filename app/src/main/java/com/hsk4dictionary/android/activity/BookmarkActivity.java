package com.hsk4dictionary.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.hsk4dictionary.android.R;
import com.hsk4dictionary.android.model.Card;
import com.hsk4dictionary.android.utils.adapter.MyAdapter;

import java.util.ArrayList;

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

        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card("word","pronunciation","word_type","meaning"));
        ArrayList myDataset = cards;

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
}