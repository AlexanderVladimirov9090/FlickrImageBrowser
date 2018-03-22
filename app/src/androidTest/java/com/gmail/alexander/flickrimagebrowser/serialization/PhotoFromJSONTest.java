package com.gmail.alexander.flickrimagebrowser.serialization;

import com.gmail.alexander.flickrimagebrowser.datadownloader.DownloadStatus;
import com.gmail.alexander.flickrimagebrowser.datadownloader.OnDataAvailable;
import com.gmail.alexander.flickrimagebrowser.models.Photo;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by:
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class PhotoFromJSONTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void onDataAvailable() {
        OnDataAvailable onDataAvailable = mock(OnDataAvailable.class);
        PhotoFromJSON photoFromJSON = new PhotoFromJSON("https://api.flickr.com/services/feeds/photos_public.gne", "en-us", true, onDataAvailable);
        photoFromJSON.onPostExecute(new ArrayList<Photo>());
        verify(onDataAvailable, times(1)).onDataAvailable(ArgumentMatchers.<Photo>anyList(), any(DownloadStatus.class));
    }

    @Test
    public void brokenLink() {
        OnDataAvailable onDataAvailable = mock(OnDataAvailable.class);
        PhotoFromJSON photoFromJSON = new PhotoFromJSON("BrokenLink", "en-us", true, onDataAvailable);
        photoFromJSON.execute("Some query");
        verify(onDataAvailable, never()).onDataAvailable(ArgumentMatchers.<Photo>anyList(), any(DownloadStatus.class));
    }

    @Test
    public void downloadedData() {
        OnDataAvailable onDataAvailable = mock(OnDataAvailable.class);
        PhotoFromJSON photoFromJSON = new PhotoFromJSON("https://api.flickr.com/services/feeds/photos_public.gne", "en-us", true, onDataAvailable);
        List<Photo> result = photoFromJSON.doInBackground("https://api.flickr.com/services/feeds/photos_public.gne");
        assertNotNull(result);
    }

    @Test
    public void notDownloaded(){
        OnDataAvailable onDataAvailable = mock(OnDataAvailable.class);
        PhotoFromJSON photoFromJSON = new PhotoFromJSON("no link", "en-us", true, onDataAvailable);
        List<Photo> result = photoFromJSON.doInBackground("brokenLink");
        assertNull(result);
    }
}