package com.hsk4dictionary.android.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hsk4dictionary.android.R;
import com.hsk4dictionary.support.opensource.retrofit.RestfulAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends Activity {

    @BindView(R.id.card_item_search)        Button    mCardItemSearch;
    @BindView(R.id.card_item_word)          TextView  mCardItemWord;
    @BindView(R.id.card_item_pronunciation) TextView  mCardItemPronunciation;
    @BindView(R.id.card_item_word_type)     TextView  mCardItemWordType;
    @BindView(R.id.card_item_meaning)       TextView  mCardItemMeaning;
    @BindView(R.id.progress)                ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mCardItemSearch.setOnClickListener(v -> {
            final AlertDialog alertdialog = new AlertDialog.Builder(this)
                .setTitle(R.string.card_item_search_text)
                .setView(R.layout.dialog_search)
                .setPositiveButton(R.string.dialog_search_positive, (dialog, which) -> {
                        final int id = Integer.parseInt(((EditText) ((AlertDialog) dialog).findViewById(R.id.dialog_search_id)).getText().toString());
                        mProgress.setVisibility(View.VISIBLE);
                        RestfulAdapter.getInstance().get_card(id)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                card -> {
                                    mProgress.setVisibility(View.GONE);

                                    mCardItemWord.setText(card.word);
                                    mCardItemPronunciation.setText(card.pronunciation);
                                    mCardItemWordType.setText(card.word_type);
                                    mCardItemMeaning.setText(card.meaning.trim());

                                    mCardItemWord.setVisibility(View.VISIBLE);
                                    mCardItemPronunciation.setVisibility(View.VISIBLE);
                                    mCardItemWordType.setVisibility(View.VISIBLE);
                                    mCardItemMeaning.setVisibility(View.VISIBLE);

                                },
                                error -> {
                                    mProgress.setVisibility(View.GONE);
                                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            );
                    }
                )
                .setNegativeButton(R.string.dialog_search_negative, (dialog, which) -> dialog.dismiss())
                .create();

            alertdialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
            alertdialog.show();
        });
    }
}
