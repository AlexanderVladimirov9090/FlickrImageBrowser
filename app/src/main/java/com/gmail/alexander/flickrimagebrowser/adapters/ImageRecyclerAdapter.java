package com.gmail.alexander.flickrimagebrowser.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.alexander.flickrimagebrowser.R;
import com.gmail.alexander.flickrimagebrowser.holders.ImageViewHolder;
import com.gmail.alexander.flickrimagebrowser.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by:
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 *             Adapter for image downloaded from flicker.
 */

public class ImageRecyclerAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    private static final String TAG = "ImageRecyclerAdapter";
    private List<Photo> photos;
    private Context context;

    public ImageRecyclerAdapter(List<Photo> photos, Context context) {
        this.photos = photos;
        this.context = context;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Called by the layout manager when it needs new view
        Log.d(TAG, "onCreateViewHolder: new view requested");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.browse, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        // Called bt layout manager when it wants new data in an existing row
        if(photos== null || photos.size()==0){
            holder.thumbnail.setImageResource(R.drawable.ic_launcher_background);
            holder.title.setText("No photos matches your`s search.");
        }else {
            Photo photoItem = photos.get(position);
            Log.d(TAG, "onBindViewHolder: Photo title: " + photoItem.getTitle() + " position: " + position);
            Picasso.with(context).load(photoItem.getImage())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.thumbnail);

            holder.title.setText(photoItem.getTitle());
        }
        }

    /**
     * Counts items.
     * @return
     */
    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: called");
        return ((photos != null) && (photos.size() != 0) ? photos.size() : 1);
    }

    /**
     * Load new data and notify the change.
     * @param newPhotos
     */
    public void loadNewData(List<Photo> newPhotos) {
        photos = newPhotos;
        notifyDataSetChanged();
    }

    /**
     * Gets photo from photos collection.
     * @param position
     * @return
     */
    public Photo getPhoto(int position){
        return ((photos !=null)&& (photos.size() !=0) ? photos.get(position) : null);
    }
}
