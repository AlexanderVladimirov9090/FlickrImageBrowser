package com.gmail.alexander.flickrimagebrowser.serialization;

import com.gmail.alexander.flickrimagebrowser.datadownloader.DownloadStatus;
import com.gmail.alexander.flickrimagebrowser.datadownloader.OnDataAvailable;
import com.gmail.alexander.flickrimagebrowser.models.Photo;

import org.junit.Test;
import org.mockito.ArgumentMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by:
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class PhotoFromJSONTest {


    @Test
    public void deserializationOfJson() {


        OnDataAvailable onDataAvailable = mock(OnDataAvailable.class);
        PhotoFromJSON photoFromJSON = new PhotoFromJSON("https://api.flickr.com/services/feeds/photos_public.gne", "en-us", true, onDataAvailable);
        verify(onDataAvailable, times(1)).onDataAvailable(ArgumentMatchers.<Photo>anyList(), any(DownloadStatus.class));
        photoFromJSON.execute("");


    }

}