package com.example.mainscreen2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainscreen2.API.ApiService;
import com.example.mainscreen2.Model.Category;
import com.example.mainscreen2.Model.Playlist;
import com.example.mainscreen2.Model.Song;
import com.example.mainscreen2.PlayMusicActivity;
import com.example.mainscreen2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder>  {
    private List<Song> songs;
    private Context context;
    private String like;

    public SongAdapter(List<Song> songs, Context context) {
        this.songs = songs;
        this.context = context;
    }

    @NonNull
    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View albumView =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song, parent, false);
        SongAdapter.ViewHolder viewHolder = new SongAdapter.ViewHolder(albumView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.ViewHolder holder, int position) {
        Song song = songs.get(position);
        Picasso.with(context).load(song.getSongImageUrl()).into(holder.img_song);
        holder.tv_nameSong.setText(song.getSongName());
        holder.tv_nameSinger.setText(song.getSingerName());
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView img_song;
        public TextView tv_nameSong;
        public TextView tv_nameSinger;
        public ImageView img_heart;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_song = itemView.findViewById(R.id.img_song);
            tv_nameSong = itemView.findViewById(R.id.tv_nameSong);
            tv_nameSinger = itemView.findViewById(R.id.tv_nameSinger);
            img_heart = itemView.findViewById(R.id.img_heart);
            img_heart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    img_heart.setImageResource(R.drawable.iconloved);
                    ApiService.apiService.updateLike("1", songs.get(getPosition()).getSongId() ).enqueue(new Callback<List<Song>>() {
                        @Override
                        public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                            Toast.makeText(context, "Liked", Toast.LENGTH_SHORT).show();
                        }
                        @Override
                        public void onFailure(Call<List<Song>> call, Throwable t) {
                            Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show();
                        }
                    });
                            img_heart.setEnabled(false);
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayMusicActivity.class);
                    intent.putExtra("playsong", songs.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
