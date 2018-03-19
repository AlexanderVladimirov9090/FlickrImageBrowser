package com.gmail.alexander.flickrimagebrowser.datadownloader;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by:
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class GetRawDataTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void downloadOnSameThread(){
        OnDownloadComplete onDownloadComplete = mock(OnDownloadComplete.class);
        GetRawData getRawData = new GetRawData(onDownloadComplete);
        verify(onDownloadComplete).onDownloadComplete(anyString(),any(DownloadStatus.class));
        getRawData.runInSameThread("https://api.flickr.com/services/feeds/photos_public.gne?tag=hello");
    }

}