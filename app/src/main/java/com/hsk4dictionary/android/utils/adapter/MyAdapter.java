package com.hsk4dictionary.android.utils.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hsk4dictionary.android.R;
import com.hsk4dictionary.android.model.Card;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Card> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
//        @BindView(R.id.card_view) public TextView mCard;
        @BindView(R.id.text_item_word) public TextView mWord;
        @BindView(R.id.text_item_pronunciation) public TextView mPronunciation;
        @BindView(R.id.text_item_word_type) public TextView mWordType;
        @BindView(R.id.text_item_meaning) public TextView mMeaning;
        public ViewHolder(View v) {
            super(v);
//            mTextView = (TextView) v.findViewById(R.id.info_text);
            ButterKnife.bind(this, v);
        }
    }

    public MyAdapter(ArrayList<Card> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mWord.setText(mDataset.get(position).word);
        holder.mPronunciation.setText(mDataset.get(position).pronunciation);
        holder.mWordType.setText(mDataset.get(position).word_type);
        holder.mMeaning.setText(mDataset.get(position).meaning);
//        holder.mTextView.setText(mDataset[position]);
    }
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
//
//    ViewGroup parent = (ViewGroup) view.getParent();
//if (parent != null) {
//    parent.removeView(view);
//    }