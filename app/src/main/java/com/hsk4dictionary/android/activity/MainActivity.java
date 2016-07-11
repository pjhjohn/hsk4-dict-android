package com.hsk4dictionary.android.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.hsk4dictionary.android.R;
import com.hsk4dictionary.support.opensource.retrofit.RestfulAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends Activity {

    @BindView(R.id.card_id) protected EditText card_id;
    @BindView(R.id.btn)     protected Button   button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
        ButterKnife.bind(this);

        button.setOnClickListener(v -> {
            final int id = Integer.parseInt(card_id.getText().toString());
            RestfulAdapter.getInstance().get_card(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(card -> {
                    new AlertDialog.Builder(this)
                        .setTitle(String.format("cards/read/%d", id))
                        .setMessage(
                            String.format("word : %s\npronunciation : %s\nword_type: %s\nmeaning : %s",
                                card.word,
                                card.pronunciation,
                                card.word_type,
                                card.meaning
                            ))
                        .show();
                },
                error -> {
                    error.printStackTrace();
                }
            );
        });
    }
}
