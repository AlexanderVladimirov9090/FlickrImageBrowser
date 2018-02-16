package com.gmail.alexander.flickrimagebrowser.serialization;

import com.gmail.alexander.flickrimagebrowser.datadownloader.DownloadStatus;
import com.gmail.alexander.flickrimagebrowser.datadownloader.OnDataAvailable;
import com.gmail.alexander.flickrimagebrowser.datadownloader.OnDownloadComplete;
import com.gmail.alexander.flickrimagebrowser.models.Photo;

import java.util.List;

/**
 * Created by:
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

public class PhotoFromJSON implements OnDownloadComplete {
    private List<Photo> photos = null;
    private String baseUrl;
    private String language;
    private boolean matchAll;
    private final OnDataAvailable callBack;
    @Override
    public void onDownloadComplete(String data, DownloadStatus downloadStatus) {

    }
}
