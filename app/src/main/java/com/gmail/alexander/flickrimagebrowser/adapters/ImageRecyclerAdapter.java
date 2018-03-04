package com.gmail.alexander.flickrimagebrowser.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.gmail.alexander.flickrimagebrowser.holders.ImageViewHolder;
import com.gmail.alexander.flickrimagebrowser.models.Photo;

import java.util.List;

/**
 * Created by:
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

public class ImageRecyclerAdapter extends RecyclerView.Adapter<ImageViewHolder>{
    private static final String TAG = "ImageRecyclerAdapter";
    private List<Photo> photos;
    private Context context;

}
