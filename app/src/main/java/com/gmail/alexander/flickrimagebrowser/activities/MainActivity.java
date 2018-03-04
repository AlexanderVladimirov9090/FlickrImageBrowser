package com.gmail.alexander.flickrimagebrowser.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.gmail.alexander.flickrimagebrowser.R;
import com.gmail.alexander.flickrimagebrowser.adapters.ImageRecyclerAdapter;
import com.gmail.alexander.flickrimagebrowser.datadownloader.DownloadStatus;
import com.gmail.alexander.flickrimagebrowser.datadownloader.OnDataAvailable;
import com.gmail.alexander.flickrimagebrowser.models.Photo;
import com.gmail.alexander.flickrimagebrowser.serialization.PhotoFromJSON;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnDataAvailable {
    private static final String TAG = "MainActivity";
    private ImageRecyclerAdapter imageRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        imageRecyclerAdapter = new ImageRecyclerAdapter(new ArrayList<Photo>(), this);
        recyclerView.setAdapter(imageRecyclerAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        PhotoFromJSON photoFromJSON = new PhotoFromJSON("https://api.flickr.com/services/feeds/photos_public.gne", "en-us", true, this);

        photoFromJSON.execute("android, nougat");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDataAvailable(List<Photo> photos, DownloadStatus downloadStatus) {
        if (downloadStatus == DownloadStatus.OK) {
            Log.d(TAG, "onDownloadComplete: data is" + photos);
        } else {
            Log.e(TAG, "onDownloadComplete: Failed with status: " + downloadStatus);
        }
    }
}
