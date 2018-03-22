package com.gmail.alexander.flickrimagebrowser.models;

import java.io.Serializable;

/**
 * Created by:
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

public class Photo implements Serializable {

    private static final long serialVersionUID = 1L;
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

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", authorId='" + authorId + '\'' +
                ", link='" + link + '\'' +
                ", tags='" + tags + '\'' +
                ", image='" + image + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Photo photo = (Photo) o;

        if (title != null ? !title.equals(photo.title) : photo.title != null) return false;
        if (author != null ? !author.equals(photo.author) : photo.author != null) return false;
        if (authorId != null ? !authorId.equals(photo.authorId) : photo.authorId != null)
            return false;
        if (link != null ? !link.equals(photo.link) : photo.link != null) return false;
        if (tags != null ? !tags.equals(photo.tags) : photo.tags != null) return false;
        return image != null ? image.equals(photo.image) : photo.image == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }
}
