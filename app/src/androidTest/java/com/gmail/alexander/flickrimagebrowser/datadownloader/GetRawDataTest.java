package com.gmail.alexander.flickrimagebrowser.datadownloader;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by:
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 *         Testing colaboration between GetRawData and callback class.
 */
public class GetRawDataTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void onDownloadCompleteInSameThread() {
        OnDownloadComplete onDownloadComplete = mock(OnDownloadComplete.class);
        GetRawData getRawData = new GetRawData(onDownloadComplete);
        getRawData.runInSameThread("https://api.flickr.com/services/feeds/photos_public.gne?tag=hello");
        verify(onDownloadComplete).onDownloadComplete(anyString(), any(DownloadStatus.class));
    }

    @Test
    public void onPostExecuteCallsOnDownloadComplete() {
        OnDownloadComplete onDownloadComplete = mock(OnDownloadComplete.class);
        GetRawData getRawData = new GetRawData(onDownloadComplete);
        getRawData.onPostExecute("This will be downloaded data.");
        verify(onDownloadComplete).onDownloadComplete(anyString(), any(DownloadStatus.class));
    }

    @Test
    public void downloadJsonMessage() {
        OnDownloadComplete onDownloadComplete = mock(OnDownloadComplete.class);
        GetRawData getRawData = new GetRawData(onDownloadComplete);
        String result = getRawData.doInBackground("https://api.flickr.com/services/feeds/photos_public.gne?tag=hello");
        assertNotNull(result);
    }

    @Test
    public void brokenLink() {
        OnDownloadComplete onDownloadComplete = mock(OnDownloadComplete.class);
        GetRawData getRawData = new GetRawData(onDownloadComplete);
        String nullResult = getRawData.doInBackground("this is broken link123");
        assertEquals(null, nullResult);
    }
}