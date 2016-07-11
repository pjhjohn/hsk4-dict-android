package com.hsk4dictionary.android.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hsk4dictionary.android.R;
import com.hsk4dictionary.support.opensource.retrofit.RestfulAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends Activity {

    @BindView(R.id.card_search_id)          protected EditText  mCardSearchId;
    @BindView(R.id.card_search_button)      protected Button    mCardSearchButton;

    @BindView(R.id.card_item_word)          protected TextView  mCardItemWord;
    @BindView(R.id.card_item_pronunciation) protected TextView  mCardItemPronunciation;
    @BindView(R.id.card_item_word_type)     protected TextView  mCardItemWordType;
    @BindView(R.id.card_item_meaning)       protected TextView  mCardItemMeaning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mCardSearchButton.setOnClickListener(v -> {
            final int id = Integer.parseInt(mCardSearchId.getText().toString());
            RestfulAdapter.getInstance().get_card(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(card -> {
                    mCardItemWord.setText(card.word);
                    mCardItemPronunciation.setText(card.pronunciation);
                    mCardItemWordType.setText(card.word_type);
                    mCardItemMeaning.setText(card.meaning);
                },
                error -> Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show());
        });
    }
}
