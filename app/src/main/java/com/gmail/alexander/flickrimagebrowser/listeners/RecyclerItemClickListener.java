package com.gmail.alexander.flickrimagebrowser.listeners;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by:
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 *         Handles onclick events.
 */

public class RecyclerItemClickListener extends RecyclerView.SimpleOnItemTouchListener {
    private static final String TAG = "RecyclerItemClick";
    private final OnRecyclerClickListener onRecyclerClickListener;
    private final GestureDetectorCompat gestureDetectorCompat;

    public RecyclerItemClickListener(Context context, final OnRecyclerClickListener onRecyclerClickListener, final RecyclerView recyclerView) {
        this.onRecyclerClickListener = onRecyclerClickListener;
        gestureDetectorCompat = new GestureDetectorCompat(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());

                if (childView != null && onRecyclerClickListener != null) {
                    onRecyclerClickListener.onItemClick(childView, recyclerView.getChildAdapterPosition(childView));
                }
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());

                if (childView != null && onRecyclerClickListener != null) {
                    onRecyclerClickListener.onItemClick(childView, recyclerView.getChildAdapterPosition(childView));
                }
            }
        });

    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return gestureDetectorCompat.onTouchEvent(e);
    }

}
