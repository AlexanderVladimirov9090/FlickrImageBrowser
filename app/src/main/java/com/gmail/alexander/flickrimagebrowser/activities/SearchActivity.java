package com.gmail.alexander.flickrimagebrowser.activities;

import android.os.Bundle;
import android.view.Menu;
import android.widget.SearchView;

import com.gmail.alexander.flickrimagebrowser.R;

public class SearchActivity extends BaseActivity {
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        activateToolbar(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }
}
