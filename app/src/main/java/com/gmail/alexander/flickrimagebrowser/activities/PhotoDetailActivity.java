package com.gmail.alexander.flickrimagebrowser.activities;

import android.os.Bundle;

import com.gmail.alexander.flickrimagebrowser.R;

public class PhotoDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);
        activateToolbar(true);
    }

}
