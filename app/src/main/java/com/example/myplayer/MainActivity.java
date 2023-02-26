package com.example.myplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        /*TextView title = findViewById(R.id.song_title_textView);
        TextView artist = findViewById(R.id.song_artist_textView);*/


        ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song("Haunted", "Paul Van Dyk", R.raw.haunted));
        songs.add(new Song("Save the last trance for me", "Paul Oakenfold",
                R.raw.save_the_last_trance_for_me));

        CustomAdapter adapter = new CustomAdapter(songs);
        
        //set CustomAdapter as the adapter for the RecyclerView
        recyclerView.setAdapter(adapter);



        //TODO:Create custom adapter
        //TODO:Attach the adapter to the RecycleView
        //TODO: Attach LinearLayoutManager to RecycleView



        


    }
}