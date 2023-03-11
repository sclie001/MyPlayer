package com.example.myplayer;

<<<<<<< HEAD
import android.media.MediaPlayer;
=======
>>>>>>> parent of 874ded0 (implement onClick in ViewHolder)
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    private List<Song> songList = new ArrayList<>();

    /*Initialize the dataset for the adapter
    * @param list_songs contains the list of songs to populate
    * views to be used by RecyclerView*/
    public CustomAdapter(List<Song> list_songs){
        this.songList = list_songs;
    }


    /*Create new views (invoked by the layoutManager)*/
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,
                parent, false);
        return new ViewHolder(view);
    }

    /*Replace the contents of a view (invoked by layoutManager)*/
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get element from the songList at this position and replace the
        //contents of the view with that element
        Song currentSong = songList.get(position);
        holder.getSongTitle().setText(currentSong.getTitle());
        holder.getSongArtist().setText(currentSong.getArtist());
        //for now, all images are the same
        holder.getImage().setImageResource(R.mipmap.ic_launcher);
    }

    /*Return the size of songList (invoked by the layoutManager)*/
    @Override
    public int getItemCount() {
        return songList.size();
    }

    /*Provide a reference to the types of views used (custom ViewHolder)*/
    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView songTitle;
        private final TextView songArtist;
        private final ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //TODO:define click listener for ViewHolder's view

            image = itemView.findViewById(R.id.image);
            songTitle = itemView.findViewById(R.id.song_title_textView);
            songArtist = itemView.findViewById(R.id.song_artist_textView);

        }

        /*Get the song title*/
        public TextView getSongTitle() {
            return songTitle;
        }

        /*Get the artist of the song*/
        public TextView getSongArtist() {
            return songArtist;
        }

        /*Get the image*/
        public ImageView getImage() {
            return image;
        }
<<<<<<< HEAD

        @Override
        public void onClick(View view) {
            //release media player if it currently exists
            //because we are about to play a different sound file
            releaseMediaPlayer();

        }
        private void releaseMediaPlayer(){
            //if the player is not null, it may be currently playing a sound file
            if(mediaPlayer != null){
                //Regardless of the current state of the player, release its resources
                //because we no longer need it
                mediaPlayer.release();

                //set the player back to null. By setting the player to null, it is easy
                //to tell the player is not configured to play audio at the moment.
                mediaPlayer = null;
            }
        }
=======
>>>>>>> parent of 874ded0 (implement onClick in ViewHolder)
    }
}
