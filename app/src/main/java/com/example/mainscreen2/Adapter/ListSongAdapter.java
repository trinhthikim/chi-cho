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
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainscreen2.API.ApiService;
import com.example.mainscreen2.ListSongActivity;
import com.example.mainscreen2.Model.Song;
import com.example.mainscreen2.PlayMusicActivity;
import com.example.mainscreen2.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListSongAdapter extends RecyclerView.Adapter<ListSongAdapter.ViewHolder>{
    private Context context;
    private List<Song> songs;

    public ListSongAdapter(Context context, List<Song> songs) {
        this.context = context;
        this.songs = songs;
    }

    @NonNull
    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(R.layout.dong_list_song, parent, false);
//
//        return new ViewHolder(view);
//    }
    public ListSongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View view = inflater.inflate(R.layout.dong_list_song, parent, false);
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_list_song, parent, false);

        ListSongAdapter.ViewHolder viewHolder = new ListSongAdapter.ViewHolder(view);
        Log.d("list song adapter", songs.toString());
        return viewHolder;
//        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListSongAdapter.ViewHolder holder, int position) {
        Song song = songs.get(position);
        Log.d("song 1", song.getSingerName());
        holder.txtcasi.setText(song.getSingerName());
        Log.d("name singer", song.getSingerName());
        holder.txtnamesong.setText(song.getSongName());
        Log.d("name song", song.getSongName());
        holder.txtindex.setText(position + 1 + "");
        Log.d("index", position + 1 + "");

    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtindex;
        public TextView txtnamesong;
        public TextView txtcasi;
        public ImageView imgluotyeuthich;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            txtindex = itemView.findViewById(R.id.textviewlistindex);
            txtcasi = itemView.findViewById(R.id.textviewnamesinger);
            txtnamesong = itemView.findViewById(R.id.textviewnamesong);
            imgluotyeuthich = itemView.findViewById(R.id.imageviewlikelistsong);
            imgluotyeuthich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgluotyeuthich.setImageResource(R.drawable.iconloved);
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
                    imgluotyeuthich.setEnabled(false);
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
