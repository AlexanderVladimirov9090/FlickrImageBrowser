package com.gmail.alexander.flickrimagebrowser.listeners;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;

/**
 * Created by:
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 * Handles onclick events.
 */

public class RecyclerItemClickListener extends RecyclerView.SimpleOnItemTouchListener {
    private static final String TAG = "RecyclerItemClick";
    private final OnRecyclerClickListener onRecyclerClickListener;
    private final GestureDetectorCompat gestureDetectorCompat;

}
