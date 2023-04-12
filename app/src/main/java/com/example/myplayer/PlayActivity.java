package com.example.myplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private String TAG = "PlayActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        TextView songTitle = findViewById(R.id.song_title_playAct_textView);
        TextView songArtist = findViewById(R.id.song_artist_playAct_textView);

        ImageButton pause = findViewById(R.id.pause_button);
        ImageButton play = findViewById(R.id.play_button);
        ImageButton stop = findViewById(R.id.stop_button);

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

        //add the music file to the newly created media player
        mMediaPlayer = MediaPlayer.create(PlayActivity.this, audioResId);

        //TODO:handle button clicks for play, pause, and stop buttons
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.start();
                Toast.makeText(getApplicationContext(), "audio playing",
                        Toast.LENGTH_SHORT).show();
            }
        });

        //TODO:possibly add different button states: button pressed and button normal
        //https://developer.android.com/reference/android/widget/ImageButton
    }
}