package com.gmail.alexander.flickrimagebrowser.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

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

    public ImageRecyclerAdapter(List<Photo> photos, Context context) {
        this.photos = photos;
        this.context = context;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
