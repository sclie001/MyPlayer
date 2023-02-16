package com.example.myplayer;

public class Song{

    private String artist;
    private String title;
    private final int audioResourceId;

    public Song(String title, String artist, int audioResourceId){
        this.title =  title;
        this.artist = artist;
        this.audioResourceId = audioResourceId;

    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getAudioResourceId() {
        return audioResourceId;
    }
}
