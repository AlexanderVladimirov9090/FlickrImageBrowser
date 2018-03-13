package com.gmail.alexander.flickrimagebrowser.activities;

import android.content.Intent;
import android.content.res.Resources;
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
            Resources resources = getResources();

            TextView photoTitle = (TextView) findViewById(R.id.photo_title);
            String title = resources.getString(R.string.photo_title_text, photo.getTitle());
            photoTitle.setText(title);

            TextView photoTags = (TextView) findViewById(R.id.photo_tags);
            String tags = resources.getString(R.string.photo_tags, photo.getTags());

            photoTags.setText(tags);

            TextView photoAuthor = (TextView) findViewById(R.id.photo_author);
            String author = resources.getString(R.string.photo_author, photo.getAuthor());

            photoAuthor.setText(author);

            ImageView photoContent = (ImageView) findViewById(R.id.photo_image);

            Picasso.with(this).load(photo.getImage())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(photoContent);
        }
    }

}
