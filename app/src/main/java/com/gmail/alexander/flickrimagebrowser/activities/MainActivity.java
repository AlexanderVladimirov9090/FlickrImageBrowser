package com.gmail.alexander.flickrimagebrowser.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.gmail.alexander.flickrimagebrowser.R;
import com.gmail.alexander.flickrimagebrowser.adapters.ImageRecyclerAdapter;
import com.gmail.alexander.flickrimagebrowser.datadownloader.DownloadStatus;
import com.gmail.alexander.flickrimagebrowser.datadownloader.OnDataAvailable;
import com.gmail.alexander.flickrimagebrowser.listeners.OnRecyclerClickListener;
import com.gmail.alexander.flickrimagebrowser.listeners.RecyclerItemClickListener;
import com.gmail.alexander.flickrimagebrowser.models.Photo;
import com.gmail.alexander.flickrimagebrowser.serialization.PhotoFromJSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Main Activity that is a starting point ot the application.
 * Now it is displaying static query from flicker.
 */
public class MainActivity extends BaseActivity implements OnDataAvailable, OnRecyclerClickListener {
    private static final String TAG = "MainActivity";
    private ImageRecyclerAdapter imageRecyclerAdapter;

    /**
     * On create as a starting point.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activateToolbar(false);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, this, recyclerView));

        imageRecyclerAdapter = new ImageRecyclerAdapter(new ArrayList<Photo>(), this);
        recyclerView.setAdapter(imageRecyclerAdapter);
    }

    /**
     * Called when resumed.
     */
    @Override
    protected void onResume() {
        super.onResume();
        PhotoFromJSON photoFromJSON = new PhotoFromJSON("https://api.flickr.com/services/feeds/photos_public.gne", "en-us", true, this);

        photoFromJSON.execute("android, nougat");
    }

    /**
     * When menu is created.
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * When selected item from the menu.
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);

    }

    /**
     * Signals to the adapter that photos are downloaded.
     *
     * @param photos
     * @param downloadStatus
     */
    @Override
    public void onDataAvailable(List<Photo> photos, DownloadStatus downloadStatus) {
        if (downloadStatus == DownloadStatus.OK) {
            imageRecyclerAdapter.loadNewData(photos);
        } else {
            Log.e(TAG, "onDownloadComplete: Failed with status: " + downloadStatus);
        }
    }

    /**
     * Executes on click.
     *
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(View view, int position) {
        Log.d(TAG, "onItemClick: Starts");
        Toast.makeText(MainActivity.this, "Normal Click on position: " + position, Toast.LENGTH_LONG).show();
    }

    /**
     * Executes on longer click.
     *
     * @param view
     * @param position
     */
    @Override
    public void onItemLongClick(View view, int position) {
        Log.d(TAG, "onItemLongClick: Starts");
        // Toast.makeText(MainActivity.this, "Long Click on position: " + position, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, PhotoDetailActivity.class);
        intent.putExtra(PHOTO_TRANSFER , imageRecyclerAdapter.getPhoto(position));
        startActivity(intent);
    }
}
