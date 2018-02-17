package com.gmail.alexander.flickrimagebrowser.datadownloader;

import android.os.AsyncTask;

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
    private OnDownloadComplete callBack;

    public GetRawData(OnDownloadComplete callBack) {
        this.callBack = callBack;
        this.downloadStatus = DownloadStatus.IDLE;
    }

    public void runInSameThread(String s) {
        if (callBack != null) {
            callBack.onDownloadComplete(doInBackground(s), downloadStatus);
        }
    }

    @Override
    protected void onPostExecute(String s) {
        if (callBack != null) {
            callBack.onDownloadComplete(s, downloadStatus);
        }
    }

    /**
     * Downloading raw data from the resource.
     *
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