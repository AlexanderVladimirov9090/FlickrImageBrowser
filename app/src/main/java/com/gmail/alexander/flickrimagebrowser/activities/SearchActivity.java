package com.gmail.alexander.flickrimagebrowser.activities;

import android.os.Bundle;

import com.gmail.alexander.flickrimagebrowser.R;

public class SearchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        activateToolbar(true);

    }

}
