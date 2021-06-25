package com.example.mainscreen2.API;

import com.example.mainscreen2.Model.Album;
import com.example.mainscreen2.Model.Banner;
import com.example.mainscreen2.Model.Category;
import com.example.mainscreen2.Model.Playlist;
import com.example.mainscreen2.Model.Singer;
import com.example.mainscreen2.Model.Song;
import com.example.mainscreen2.Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

//Link API: https://musicplay0123456789.000webhostapp.com/Server/banner.php
//https://musicplay0123456789.000webhostapp.com/Server/Banner.php
public interface ApiService {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-mm-dd:mm:ss")
            .create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl(" https://musicplay0123456789.000webhostapp.com/Server/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);
    @GET("Banner.php")
    Call<List<Banner>> getDataBanner();

    @GET("GetUser.php")
    Call<List<User>> getDataUser();

    @GET("AlbumSuggest.php")
    Call<List<Album>> getDataAlbumSuggest();

    @GET("Playlist.php")
    Call<List<Playlist>> getDataPlaylist();

    @GET("Category.php")
    Call<List<Category>> getDataCategory();

    @GET("Singer.php")
    Call<List<Singer>> getDataSinger();

    @GET("Song.php")
    Call<List<Song>> getDataSong();

    @FormUrlEncoded
    @POST("SongToAlbum.php")
    Call<List<Song>> getDataSongToAlbum(@Field("idAlbum") String idAlbum);
}
