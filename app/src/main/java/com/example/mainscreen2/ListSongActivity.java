package com.example.mainscreen2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainscreen2.API.ApiService;
import com.example.mainscreen2.Adapter.ListSongAdapter;
import com.example.mainscreen2.Adapter.PlaylistAdapter;
import com.example.mainscreen2.Adapter.SongAdapter;
import com.example.mainscreen2.Model.Album;
import com.example.mainscreen2.Model.Category;
import com.example.mainscreen2.Model.Playlist;
import com.example.mainscreen2.Model.Singer;
import com.example.mainscreen2.Model.Song;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListSongActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewListSong;
    FloatingActionButton floatingActionButton;
    Album album;
    Playlist playlist;
    Category category;
    Singer singer;
    ImageView imglistsong;

    ArrayList<Song> songs;
    ListSongAdapter listSongAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_song);
        DataIntent();
        anhxa();
        init();
        if(album != null && !album.getAlbumName().equals("")){
            setValueInView(album.getAlbumName(), album.getAlbumImageUrl());
            getDataAlbum(album.getAlbumId());
        }
        if(playlist != null && !playlist.getPlaylistName().equals("")){
            setValueInView(playlist.getPlaylistName(), playlist.getPlaylistImageUrl());
            getDataPlaylist(playlist.getPlaylistId());
        }
        if(category != null && !category.getCategoryName().equals("")){
            setValueInView(category.getCategoryName(), category.getCategoryImageUrl());
//            getDataCategory(category.getCategoryId());
        }
        if(singer != null && !singer.getSingerName().equals("")){
            Log.d("id", singer.getSingerBannerUrl());
            setValueInView(singer.getSingerName(), singer.getSingerBannerUrl());
            getDataSinger(singer.getSingerId());
        }
    }
    private void  setValueInView(String ten, String hinh){
        collapsingToolbarLayout.setTitle(ten);
        try{
            URL url = new URL(hinh);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            if(Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN){
                collapsingToolbarLayout.setBackground(bitmapDrawable);
            }
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        Picasso.with(this).load(hinh).into(imglistsong);
    }
    private void getDataAlbum(String idAlbum){
        Log.d("id", idAlbum);
        ApiService.apiService.getDataSongToAlbum(idAlbum).enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                Log.d("Song To Album", "Call Api Success");
                songs = (ArrayList<Song>) response.body();
                listSongAdapter = new ListSongAdapter(ListSongActivity.this, songs);
                recyclerViewListSong.setAdapter(listSongAdapter);
                recyclerViewListSong.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {
                Log.d("Song To Album", "Call Api Error");
            }
        });
    }

    private void getDataPlaylist(String idPlaylist){
        Log.d("id", idPlaylist);
        ApiService.apiService.getDataSongToPlaylist(idPlaylist).enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                Log.d("Song To Playlist", "Call Api Success");
                songs = (ArrayList<Song>) response.body();

                Log.d("reponse", songs.toString());
                listSongAdapter = new ListSongAdapter(ListSongActivity.this, songs);
                recyclerViewListSong.setAdapter(listSongAdapter);
                recyclerViewListSong.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {
                Log.d("Song To Playlist", "Call Api Error");
            }
        });
    }

    private void getDataCategory(String idCategory){
        Log.d("id", idCategory);
        ApiService.apiService.getDataSongToCategory(idCategory).enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                Log.d("Song To Category", "Call Api Success");
                songs = (ArrayList<Song>) response.body();

                Log.d("reponse", songs.toString());
                listSongAdapter = new ListSongAdapter(ListSongActivity.this, songs);
                recyclerViewListSong.setAdapter(listSongAdapter);
                recyclerViewListSong.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {
                Log.d("Song To Category", "Call Api Error");
            }
        });
    }

    private void getDataSinger(String idSinger){
        Log.d("id", idSinger);
        ApiService.apiService.getDataSongToSinger(idSinger).enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                Log.d("Song To Singer", "Call Api Success");
                songs = (ArrayList<Song>) response.body();

                Log.d("reponse", songs.toString());
                listSongAdapter = new ListSongAdapter(ListSongActivity.this, songs);
                recyclerViewListSong.setAdapter(listSongAdapter);
                recyclerViewListSong.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {
                Log.d("Song To Singer", "Call Api Error");
            }
        });
    }

    private void  init(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);

    }

    private void anhxa(){
        coordinatorLayout = findViewById(R.id.coordinatorlayout);
        collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar);
        toolbar = findViewById(R.id.toolbarlist);
        recyclerViewListSong = findViewById(R.id.recyclerviewlist);
        floatingActionButton = findViewById(R.id.floatingactionbutton);
        imglistsong = findViewById(R.id.imageviewlistsong);
    }


    private void DataIntent(){
        Intent intent = getIntent();
        if(intent != null) {
            if (intent.hasExtra("album")) {
                album = (Album) intent.getSerializableExtra("album");
                Toast.makeText(this, album.getAlbumName(), Toast.LENGTH_SHORT).show();
            }
            if (intent.hasExtra("playlist")) {
                playlist = (Playlist) intent.getSerializableExtra("playlist");
                Toast.makeText(this, playlist.getPlaylistName(), Toast.LENGTH_SHORT).show();
            }
            if (intent.hasExtra("category")) {
                playlist = (Playlist) intent.getSerializableExtra("category");
                Toast.makeText(this, category.getCategoryName(), Toast.LENGTH_SHORT).show();
            }
            if (intent.hasExtra("singer")) {
                singer = (Singer) intent.getSerializableExtra("singer");
                Toast.makeText(this, singer.getSingerName(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}