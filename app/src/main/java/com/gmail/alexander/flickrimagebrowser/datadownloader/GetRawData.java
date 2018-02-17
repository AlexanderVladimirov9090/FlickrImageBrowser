package com.gmail.alexander.flickrimagebrowser.datadownloader;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by:
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class GetRawData extends AsyncTask<String, Void, String> {
    private static String TAG = "GetRawData";
    private DownloadStatus downloadStatus;
    private OnDownloadComplete onDownloadComplete;
    public GetRawData(OnDownloadComplete callBack) {
        this.onDownloadComplete = callBack;
        this.downloadStatus = DownloadStatus.IDLE;
    }

    public void runInSameThread(String s){
        Log.d(TAG, "runInSameThread: Starts");
        onPostExecute(doInBackground(s));
        Log.d(TAG, "runInSameThread: Ends.");
    }

    @Override
    protected void onPostExecute(String s) {
        Log.d(TAG, "onPostExecute: parameter: " + s);
            if (onDownloadComplete!=null){
                onDownloadComplete.onDownloadComplete(s,downloadStatus);
            }
        Log.d(TAG, "onPostExecute: ends");
    }

    /**
     * Downloading raw data from the resource.
     * @param strings given resource.
     * @return raw data from the resource.
     */
    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        if (strings == null) {
            downloadStatus = DownloadStatus.NOT_INITIALISED;
            return null;
        }
        try {
            downloadStatus = DownloadStatus.PROCESSING;
            URL url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            int response = connection.getResponseCode();
            Log.d(TAG, "doInBackground: Response code was: " + response);
            StringBuilder result = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = null;
            while (null != (line = reader.readLine())) {
                result.append(line).append("\n");

            }
            downloadStatus = DownloadStatus.OK;
            return result.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        downloadStatus = DownloadStatus.FAIL_OR_EMPTY;
        return null;
    }
}
