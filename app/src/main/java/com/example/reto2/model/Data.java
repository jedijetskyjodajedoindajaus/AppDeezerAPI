package com.example.reto2.model;

public class Data {

    private String id;
    private String title;
    private String nb_tracks;
    private String picture;
    private User user;
    private String picture_big;
    private TrackContainer tracks;


    public Data(String title, String nb_tracks, String picture, User user, String picture_big, String id, TrackContainer tracks) {
        this.title = title;
        this.nb_tracks = nb_tracks;
        this.picture = picture;
        this.picture_big = picture_big;
        this.user = user;
        this.id = id;
        this.tracks = tracks;
    }

    public Data() {
    }


    public TrackContainer getTracks() {
        return tracks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(String nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPicture_big() {
        return picture_big;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPicture_big(String picture_big) {
        this.picture_big = picture_big;
    }

    public void setTracks(TrackContainer tracks) {
        this.tracks = tracks;
    }
}
