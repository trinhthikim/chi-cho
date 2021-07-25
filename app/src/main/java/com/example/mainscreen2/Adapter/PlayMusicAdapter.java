package com.example.mainscreen2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainscreen2.Model.Singer;
import com.example.mainscreen2.Model.Song;
import com.example.mainscreen2.R;

import java.util.ArrayList;
import java.util.List;

public class PlayMusicAdapter extends RecyclerView.Adapter<PlayMusicAdapter.ViewHolder> {
    Context context;
    ArrayList<Song> songs;

    public PlayMusicAdapter(Context context, ArrayList<Song> songs) {
        this.songs=songs;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_play_music, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = songs.get(position);
        holder.txtindex.setText(position + 1 + "");
        holder.txtnamesong.setText(song.getSongName());
        holder.txtnamesinger.setText(song.getSingerName());


    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtindex, txtnamesong, txtnamesinger;
        public ViewHolder(View itemView) {
            super(itemView);
            txtindex = itemView.findViewById(R.id.textviewplaymusicindex);
            txtnamesong = itemView.findViewById(R.id.textviewplaymusicnamesong);
            txtnamesinger = itemView.findViewById(R.id.textviewplaymusicnamesinger);
        }
    }
}
