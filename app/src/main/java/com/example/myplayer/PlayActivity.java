package com.example.myplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private String TAG = "PlayActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        TextView songTitle = findViewById(R.id.song_title_playAct_textView);
        TextView songArtist = findViewById(R.id.song_artist_playAct_textView);

        Intent intent = getIntent();//create Intent object

        String song_title_str = intent.getStringExtra("song-title");
        songTitle.setText(song_title_str);

        String artist_str = intent.getStringExtra("song-artist");
        songArtist.setText(artist_str);

        //layout_edits is branched from here

        //TODO: accept song file sent
        Bundle bundle = getIntent().getExtras();
        int audioResId = bundle.getInt("audio resource id");
        Log.d(TAG, String.valueOf(audioResId));




        //TODO:handle button clicks for play, pause, and stop buttons

        //TODO:possibly add different button states: button pressed and button normal
        //https://developer.android.com/reference/android/widget/ImageButton
    }
}