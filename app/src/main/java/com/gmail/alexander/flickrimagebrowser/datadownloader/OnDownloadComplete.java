package com.gmail.alexander.flickrimagebrowser.datadownloader;

/**
 * Created by:
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

public interface OnDownloadComplete {
    void onDownloadComplete(String data, DownloadStatus downloadStatus);
}
