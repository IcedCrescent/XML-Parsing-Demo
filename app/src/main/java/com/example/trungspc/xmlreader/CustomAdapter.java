package com.example.trungspc.xmlreader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trungspc.xmlreader.parser.Song;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Song> {
    private Context context;
    private List<Song> songList;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Song> objects) {
        super(context, resource, objects);
        this.context = context;
        songList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.item_song, parent, false);
        }
        ImageView ivThump = listItem.findViewById(R.id.iv_thumbnail);
        TextView tvSongTitle = listItem.findViewById(R.id.tv_title);
        TextView tvSongArtist = listItem.findViewById(R.id.tv_artist);
        TextView tvDuration = listItem.findViewById(R.id.tv_duration);
        Song currentSong = songList.get(position);
        tvSongTitle.setText(currentSong.title);
        tvSongArtist.setText(currentSong.artist);
        tvDuration.setText(currentSong.duration);
        Picasso.get().load(currentSong.img).into(ivThump);
        return listItem;
    }
}
