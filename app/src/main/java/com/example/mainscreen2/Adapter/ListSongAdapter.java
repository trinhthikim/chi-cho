package com.example.mainscreen2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainscreen2.Model.Song;
import com.example.mainscreen2.R;

import java.util.ArrayList;

public class ListSongAdapter extends RecyclerView.Adapter<ListSongAdapter.ViewHolder>{
    Context context;
    ArrayList<Song> songs;

    public ListSongAdapter(Context context, ArrayList<Song> songs) {
        this.context = context;
        this.songs = songs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_list_song, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = songs.get(position);
        holder.txtcasi.setText(song.getSingerName());
        holder.txtnamesong.setText(song.getSongName());
        holder.txtindex.setText(position + 1 + "");
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtindex, txtnamesong, txtcasi;
        ImageView imgluotyeuthich;
        public ViewHolder(View itemView){
            super(itemView);
            txtindex = itemView.findViewById(R.id.textviewlistindex);
            txtcasi = itemView.findViewById(R.id.textviewnamesinger);
            txtnamesong = itemView.findViewById(R.id.textviewnamesong);
            imgluotyeuthich = itemView.findViewById(R.id.imageviewlikelistsong);
        }
    }


}
