package com.hsk4dictionary.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.hsk4dictionary.android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuActivity extends Activity {

    @BindView(R.id.menu_title)      TextView mMenuTitle;
    @BindView(R.id.menu_search)     Button mMenuSearch;
    @BindView(R.id.menu_bookmark)   Button mMenuBookMark;
    @BindView(R.id.menu_github)     Button mMenuGitHub;
    @BindView(R.id.menu_exit)       Button mMenuExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        mMenuSearch.setOnClickListener(v -> this.startActivity(new Intent(this, MainActivity.class)));

        mMenuBookMark.setOnClickListener(v -> this.startActivity(new Intent(this, BookmarkActivity.class)));

        mMenuGitHub.setOnClickListener(v -> {
            String url = "https://github.com/pjhjohn/hsk4-dict-android";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });

        mMenuExit.setOnClickListener(v -> this.finishAffinity());
    }
}
