package com.gmail.alexander.flickrimagebrowser.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.alexander.flickrimagebrowser.R;
import com.gmail.alexander.flickrimagebrowser.models.Photo;
import com.squareup.picasso.Picasso;

public class PhotoDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);
        activateToolbar(true);

        Intent intent = getIntent();
        Photo photo =(Photo) intent.getSerializableExtra(PHOTO_TRANSFER);
        if(photo != null){
            TextView photoTitle = (TextView) findViewById(R.id.photoTitle);
            photoTitle.setText("Title: "+photo.getTitle());

            TextView photoTags = (TextView) findViewById(R.id.photoTags);
            photoTags.setText("Tags: "+ photo.getTags());

            TextView photoAuthor = (TextView) findViewById(R.id.photoAuthor);
            photoAuthor.setText("Author: " + photo.getAuthor());

            ImageView photoContent = (ImageView) findViewById(R.id.photoImage);

            Picasso.with(this).load(photo.getImage())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(photoContent);
        }
    }

}
