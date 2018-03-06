package com.gmail.alexander.flickrimagebrowser.listeners;

import android.view.View;

/**
 * Created by:
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

public interface OnRecyclerClickListener {

    void onItemClick(View view, int position);
    void onItemLongClick(View view, int position);

}
