package com.gmail.alexander.flickrimagebrowser.holders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.alexander.flickrimagebrowser.R;

/**
 * Created by:
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

public class ImageViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "ImageViewHolder";
    ImageView thumbnail = null;
    TextView title = null;

    public ImageViewHolder(View itemView) {
        super(itemView);
        Log.d(TAG, "ImageViewHolder: Constructor Called");
        this.thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        this.title = (TextView) itemView.findViewById(R.id.photoTitle);
    }
}
