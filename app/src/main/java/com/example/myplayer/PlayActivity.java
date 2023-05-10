package com.example.myplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
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
        ImageView image = findViewById(R.id.imageView_playAct);

        ImageButton pause = findViewById(R.id.pause_button);
        ImageButton play = findViewById(R.id.play_button);
        ImageButton stop = findViewById(R.id.stop_button);

        disableButton(pause);
        disableButton(stop);

        Intent intent = getIntent();//create Intent object

        String song_title_str = intent.getStringExtra("song-title");
        songTitle.setText(song_title_str);

        String artist_str = intent.getStringExtra("song-artist");
        songArtist.setText(artist_str);

        //accept song file sent
        Bundle bundle = getIntent().getExtras();
        int audioResId = bundle.getInt("audio resource id");
        Log.d(TAG, String.valueOf(audioResId));

        //accept the image sent
        int imageResourceId = bundle.getInt("image");
        image.setImageResource(imageResourceId);




        //add the music file to the newly created media player
        mMediaPlayer = MediaPlayer.create(PlayActivity.this, audioResId);

        //handle button clicks for play, pause, and stop buttons
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mMediaPlayer == null){
                    mMediaPlayer = MediaPlayer.create(PlayActivity.this, audioResId);
                }
                mMediaPlayer.start();
                Toast.makeText(getApplicationContext(), "audio playing",
                        Toast.LENGTH_SHORT).show();

                enableButton(pause);
                enableButton(stop);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.stop();
                mMediaPlayer.release();
                mMediaPlayer = null;

                disableButton(pause);
                disableButton(stop);
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.pause();

                disableButton(stop);
                disableButton(pause);
            }
        });
    }

    /**
     * Disable button
     * @param button button to disable
     */
    private void disableButton(ImageButton button){
        button.setEnabled(false);
        button.setImageAlpha(45);
    }

    /**
     * Enable button
     * @param button button to enable
     */
    private void enableButton(ImageButton button){
        button.setEnabled(true);
        button.setImageAlpha(255);
    }
}