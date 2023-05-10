package com.example.myplayer;

public class Song{

    private String artist;
    private String title;
    private final int audioResourceId;
    private int imageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Song object
     * @param title title of the song
     * @param artist artist of the song
     * @param audioResourceId audio resource id for the audio file associated with the song
     */
    public Song(String title, String artist, int audioResourceId){
        this.title =  title;
        this.artist = artist;
        this.audioResourceId = audioResourceId;

    }

    /**
     * Create a new Song object
     * @param title title of the song
     * @param artist artist of the song
     * @param audioResourceId audio resource id for the audio file associated with the song
     * @param imageResourceId image resource id for the image file associated with the song
     */
    public Song(String title, String artist, int audioResourceId, int imageResourceId){
        this.title =  title;
        this.artist = artist;
        this.audioResourceId = audioResourceId;
        this.imageResourceId = imageResourceId;
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

    /**
     * Determine if song has an image associated with it
     * @return false if imageResourceId -1, otherwise return true
     */
    public boolean hasImage(){
        if(imageResourceId != -1){
            return true;
        }
        else{
            return false;
        }
    }
    //TODO: add a method to get the image resource id
}
