package com.gmail.alexander.flickrimagebrowser.models;

/**
 * Created by:
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

public class Photo {
    private String title;
    private String author;
    private String authorId;
    private String link;
    private String tags;
    private String image;

    public Photo(String title, String author, String authorId, String link, String tags, String image) {
        this.title = title;
        this.author = author;
        this.authorId = authorId;
        this.link = link;
        this.tags = tags;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }


    public String getAuthorId() {
        return authorId;
    }


    public String getLink() {
        return link;
    }


    public String getTags() {
        return tags;
    }


    public String getImage() {
        return image;
    }

}
