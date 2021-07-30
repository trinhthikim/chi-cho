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

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.Body;
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
            .client(new OkHttpClient.Builder()
                                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor
                                                                                .Level.BODY))
                                                                                .build())
            .build()
            .create(ApiService.class);
    @GET("Banner.php")
    Call<List<Banner>> getDataBanner();

//    @GET("User.php")
//    Call<List<User>> getDataUser();

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

    @POST("Register.php")
    Call<User> signUp(@Body User user);

    @POST("Login.php")
    Call<User> login(@Body User user);

    @POST("User.php")
    Call<User> getDataUser(@Body User user);

    @POST("CreatePlaylist.php")
    Call<Playlist> createPlayList(@Body Playlist playlist);

    @POST("Playlist.php")
    Call<List<Playlist>> loadPlayListUser(@Body User user);

    @POST("resetPassword.php")
    Call<User> resetPassword(@Body User user);

    @POST("resetPassword.php")
    Call<User> resetName(@Body User user);

    @FormUrlEncoded
    @POST("SongToAlbum.php")
    Call<List<Song>> getDataSongToAlbum(@Field("idAlbum") String idAlbum);

    @FormUrlEncoded
    @POST("SongToPlaylist.php")
    Call<List<Song>> getDataSongToPlaylist(@Field("idPlaylist") String idPlaylist);

    @FormUrlEncoded
    @POST("SongToCategory.php")
    Call<List<Song>> getDataSongToCategory(@Field("idCategory") String idCategory);

    @FormUrlEncoded
    @POST("SongToSinger.php")
    Call<List<Song>> getDataSongToSinger(@Field("idSinger") String idSinger);

    @FormUrlEncoded
    @POST("UpdateLike.php")
    Call<String> updateLike(@Field("luotthich") String luotthich, @Field("idSong") String idSong);

    @POST("SearchSong.php")
    Call<List<Song>> searchSong(@Field("keywork") String keywork);
}
