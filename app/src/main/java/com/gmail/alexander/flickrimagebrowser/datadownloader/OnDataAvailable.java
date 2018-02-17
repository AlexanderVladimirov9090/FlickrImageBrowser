package com.gmail.alexander.flickrimagebrowser.datadownloader;

import com.gmail.alexander.flickrimagebrowser.models.Photo;

import java.util.List;

/**
 * Created by:
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

public interface OnDataAvailable {

    void onDataAvailable(List<Photo> photos, DownloadStatus downloadStatus);
}
