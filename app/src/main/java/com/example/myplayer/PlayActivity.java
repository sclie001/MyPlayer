package com.example.myplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //TODO: accept data sent from recycleView
        TextView songTitle = findViewById(R.id.song_title_playAct_textView);
        TextView songArtist = findViewById(R.id.song_artist_playAct_textView);

        Intent intent = getIntent();//create Intent object

        String song_title_str = intent.getStringExtra("song-title");
        songTitle.setText(song_title_str);

        String artist_str = intent.getStringExtra("song-artist");
        songArtist.setText(artist_str);

        //TODO:handle button clicks for play, pause, and stop buttons

        //TODO:possibly add different button states: button pressed and button normal
        //https://developer.android.com/reference/android/widget/ImageButton
    }
}