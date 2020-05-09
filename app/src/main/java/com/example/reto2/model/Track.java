package com.example.reto2.model;

import java.io.Serializable;

public class Track implements Serializable {

    private String title;
    private String duration;
    private Artist artist;
    private Album album;
    private String id;
    private String share;
    private String release_date;
    private String description;
    private String preview;


    public Track(String title, String duration, Artist artist, Album album, String id, String share, String release_date, String description, String preview) {
        this.title = title;
        this.duration = duration;
        this.artist = artist;
        this.album = album;
        this.id = id;
        this.share = share;
        this.release_date = release_date;
        this.description = description;
        this.preview = preview;
    }

    public Track() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }
}
