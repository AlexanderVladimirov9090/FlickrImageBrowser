package com.gmail.alexander.flickrimagebrowser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.gmail.alexander.flickrimagebrowser.datadownloader.DownloadStatus;
import com.gmail.alexander.flickrimagebrowser.datadownloader.GetRawData;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: starts");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetRawData getRawData = new GetRawData(this);
        getRawData.execute("https://api.flickr.com/services/feeds/photos_public.gne/?tags=android&format=json&nojsoncallback=1");
        Log.d(TAG, "onCreate: ends");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.d(TAG, "onCreateOptionsMenu() returned: " + true);
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

        Log.d(TAG, "onOptionsItemSelected() returned: returned");
        return super.onOptionsItemSelected(item);
    }

    public void onDownloadComplete(String data, DownloadStatus downloadStatus){
        if(downloadStatus == DownloadStatus.OK){
            Log.d(TAG, "onDownloadComplete: data is" + data);
        }else {
            Log.e(TAG, "onDownloadComplete: Failed with status: "+ downloadStatus );
        }
    }
}
