package com.example.mainscreen2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mainscreen2.Model.Playlist;
import com.example.mainscreen2.Model.Song;
import com.example.mainscreen2.Model.User;
import com.example.mainscreen2.R;

import java.util.List;

public class PlaylistUserAdapter extends RecyclerView.Adapter<PlaylistUserAdapter.ViewHolder>  {
    private List<Playlist> playlists;
    private Context context;
    private User user;

    public PlaylistUserAdapter(List<Playlist> playlists, Context context, User user) {
        this.playlists=playlists;
        this.context=context;
        this.user = user;
    }

    @NonNull
    @Override
    public PlaylistUserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View albumView =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playlist_user, parent, false);
        PlaylistUserAdapter.ViewHolder viewHolder = new PlaylistUserAdapter.ViewHolder(albumView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistUserAdapter.ViewHolder holder, int position) {
        Playlist playlist = playlists.get(position);
        Glide.with(context).load(playlist.getPlaylistImageUrl()).into(holder.image);
        holder.name.setText(playlist.getPlaylistName());
        holder.nameUser.setText(user.getUsername());
    }

    @Override
    public int getItemCount() {
        return playlists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView name;
        public TextView nameUser;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            nameUser = itemView.findViewById(R.id.nameUser);
        }
    }
}
