package com.gmail.alexander.flickrimagebrowser.serialization;

import android.net.Uri;
import android.util.Log;

import com.gmail.alexander.flickrimagebrowser.datadownloader.DownloadStatus;
import com.gmail.alexander.flickrimagebrowser.datadownloader.GetRawData;
import com.gmail.alexander.flickrimagebrowser.datadownloader.OnDataAvailable;
import com.gmail.alexander.flickrimagebrowser.datadownloader.OnDownloadComplete;
import com.gmail.alexander.flickrimagebrowser.models.Photo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by:
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

public class PhotoFromJSON implements OnDownloadComplete {
    private static final String TAG = "PhotoFromJSON";
    private List<Photo> photos = null;
    private String baseUrl;
    private String language;
    private boolean matchAll;
    private final OnDataAvailable callBack;

    public PhotoFromJSON(String baseUrl, String language, boolean matchAll, OnDataAvailable callBack) {
        Log.d(TAG, "PhotoFromJSON: called");
        this.baseUrl = baseUrl;
        this.language = language;
        this.matchAll = matchAll;
        this.callBack = callBack;
    }

    @Override
    public void onDownloadComplete(String data, DownloadStatus downloadStatus) {
        if (downloadStatus == DownloadStatus.OK) {
            photos = new ArrayList<>();
            try {
                JSONObject jsonData = new JSONObject(data);
                JSONArray itemsArray = jsonData.getJSONArray("items");
                for (int i = 0; i < itemsArray.length(); i++) {
                    JSONObject jsonPhoto = itemsArray.getJSONObject(i);
                    String title = jsonPhoto.getString("title");
                    String author = jsonPhoto.getString("author");
                    String authorId = jsonPhoto.getString("author_id");
                    String tags = jsonPhoto.getString("tags");

                    JSONObject jsonMedia = jsonPhoto.getJSONObject("media");
                    String photoUrl = jsonMedia.getString("m");
                    String link = photoUrl.replaceFirst("_m.", "_b.");
                    Photo photo = new Photo(title, author, authorId, link, tags, photoUrl);
                    photos.add(photo);
                    Log.d(TAG, "onDownloadComplete: " + photo.toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
                downloadStatus = DownloadStatus.FAIL_OR_EMPTY;
            }
            if (callBack != null) {
                callBack.onDataAvailable(photos, downloadStatus);
            }
        }
    }

    public void executeOnSameThread(String searchCriteria) {
        Log.d(TAG, "executeOnSameThread: Starts");
        String destinationUri = createUri(searchCriteria, language, matchAll);
        GetRawData getRawData = new GetRawData(this);
        getRawData.execute(destinationUri);
        Log.d(TAG, "executeOnSameThread: ends");
    }

    private String createUri(String searchCriteria, String language, boolean matchAll) {
        return Uri.parse(baseUrl).buildUpon().appendQueryParameter("tags", searchCriteria)
                .appendQueryParameter("tagmode", matchAll ? "ALL" : "ANY")
                .appendQueryParameter("lang", language)
                .appendQueryParameter("format", "json")
                .appendQueryParameter("nojsoncallback", "1")
                .build().toString();
    }
}
