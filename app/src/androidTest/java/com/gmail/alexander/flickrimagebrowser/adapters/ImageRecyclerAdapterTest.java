package com.gmail.alexander.flickrimagebrowser.adapters;

import com.gmail.alexander.flickrimagebrowser.models.Photo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static android.support.test.InstrumentationRegistry.getContext;
import static junit.framework.Assert.assertEquals;

/**
 * Created by:
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class ImageRecyclerAdapterTest {

    @Test
    public void getCertainPhoto() {
        List<Photo> photos = new ArrayList<>();
        Photo expected = new Photo("some title", "some author", "Some id", "app/test_data/picture.jpg", "some tag", "app/test_data/picture.jpg");
        photos.add(new Photo("some title", "some author", "Some id", "app/test_data/picture.jpg", "some tag", "app/test_data/picture.jpg"));
        photos.add(new Photo("other title", "other author", "other id", "other link", "other tag", "other image path"));
        ImageRecyclerAdapter imageRecyclerAdapter = new ImageRecyclerAdapter(photos, getContext());
        Photo actual = imageRecyclerAdapter.getPhoto(0);
        assertEquals(expected, actual);
    }

    @Test
    public void loadNewPhotos() {
        List<Photo> oldPhotos = new ArrayList<>();
        Photo expected = new Photo("new title", "new auhtor", "new id", "app/test_data/picture.jpg", "new tag", "app/test_data/picture.jpg");
        oldPhotos.add(new Photo("some title", "some author", "Some id", "app/test_data/picture.jpg", "some tag", "app/test_data/picture.jpg"));
        oldPhotos.add(new Photo("other title", "other author", "other id", "other link", "other tag", "other image path"));

        ImageRecyclerAdapter imageRecyclerAdapter = new ImageRecyclerAdapter(oldPhotos, getContext());

        List<Photo> newPhotos = new ArrayList<>();
        newPhotos.add(new Photo("new title", "new auhtor", "new id", "app/test_data/picture.jpg", "new tag", "app/test_data/picture.jpg"));
        imageRecyclerAdapter.loadNewData(newPhotos);
        Photo actual = imageRecyclerAdapter.getPhoto(0);

        assertEquals(expected, actual);
    }

    @Test
    public void countPhotos() {
        List<Photo> photos = new ArrayList<>();
        photos.add(new Photo("some title1", "some author", "Some id", "app/test_data/picture.jpg", "some tag", "app/test_data/picture.jpg"));
        photos.add(new Photo("other title2", "other author", "other id", "other link", "other tag", "other image path"));
        ImageRecyclerAdapter imageRecyclerAdapter = new ImageRecyclerAdapter(photos, getContext());
        int actualCount = imageRecyclerAdapter.getItemCount();
        assertEquals(2, actualCount);
    }
}