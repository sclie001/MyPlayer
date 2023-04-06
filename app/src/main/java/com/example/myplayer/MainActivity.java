package com.example.myplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        //LinearLayoutManager will layout elements in a similar fashion to
        //the way ListView would layout elements.
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);


        ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song("Haunted", "Paul Van Dyk", R.raw.haunted));
        songs.add(new Song("Save the last trance for me", "Paul Oakenfold",
                R.raw.save_the_last_trance_for_me));

        CustomAdapter adapter = new CustomAdapter(songs);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        adapter.setOnItemClickListener(new CustomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View viewItem, int position) {
                String artist = songs.get(position).getArtist();
                String title = songs.get(position).getTitle();
                int song = songs.get(position).getAudioResourceId();

                Toast.makeText(MainActivity.this, artist + "was clicked!",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                intent.putExtra("Title", title);
                startActivity(intent);
            }
        });


        //TODO: pass recycleView data to play activity

        //TODO: add image to Song in order to test that a click changes the image on play activity
        
        //TODO: update song list



        


    }
}