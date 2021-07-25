package com.example.mainscreen2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mainscreen2.Model.Song;

import java.util.ArrayList;

public class PlayMusicActivity extends AppCompatActivity {
    ImageView  imgCD;
    ImageButton btnPlay, btnPreview, btnNext, btnRandom, btnRepeat;
    MediaPlayer player;
    CountDownTimer countDownTimer;
    SeekBar seekBar;
    TextView tvTimeRun, tvTimeAll;
    Toolbar toolbarplaymusic;
    public static ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        init();
        getDataFromIntent();



    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        songs.clear();
        if(intent != null) {
            if (intent.hasExtra("playsong")) {
                Song song = intent.getParcelableExtra("playsong");
                songs.add(song);
                Log.d("song", song.getSongName());
            }
            if (intent.hasExtra("playListSong")) {
                ArrayList<Song> playListSong = intent.getParcelableArrayListExtra("playListSong");
                songs = playListSong;
                for(int i=0; i<playListSong.size(); i++){
                    Log.d("song", playListSong.get(i).getSongName());
                }
            }
        }
    }

    private void init() {
        seekBar = findViewById(R.id.seekBar);
        tvTimeRun = findViewById(R.id.tvTimeRun);
        tvTimeAll = findViewById(R.id.tvTimeAll);
        imgCD = findViewById(R.id.imgCD);
        btnPlay = findViewById(R.id.btnPlay);
        btnPreview = findViewById(R.id.btnPreview);
        btnNext = findViewById(R.id.btnNext);
        btnRandom = findViewById(R.id.imageButton);
        btnRepeat = findViewById(R.id.imageButton5);
        toolbarplaymusic = findViewById(R.id.toolbarplaymusic);
        setSupportActionBar(toolbarplaymusic);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarplaymusic.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbarplaymusic.setTitleTextColor(Color.WHITE);
    }


}