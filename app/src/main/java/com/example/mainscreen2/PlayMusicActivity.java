package com.example.mainscreen2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mainscreen2.Adapter.ViewPaperPlayListMusic;
import com.example.mainscreen2.Fragment.Fragment_DiaNhac;
import com.example.mainscreen2.Fragment.ListPlayMusicFragment;
import com.example.mainscreen2.Model.Song;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class PlayMusicActivity extends AppCompatActivity {
//    ImageView  imgCD;
    ImageButton btnPlay, btnPreview, btnNext, btnRandom, btnRepeat;
//    MediaPlayer player;
//    CountDownTimer countDownTimer;
    SeekBar seekBar;
    TextView tvTimeRun, tvTimeAll;
    Toolbar toolbarplaymusic;
    ViewPager viewPagerplaymusic;
    public static ArrayList<Song> songs = new ArrayList<>();
    public static ViewPaperPlayListMusic adaptersong;
    Fragment_DiaNhac fragment_diaNhac;
    ListPlayMusicFragment listPlayMusicFragment;
    MediaPlayer mediaPlayer;
    int position = 0;
    boolean repeat = false;
    boolean checkrandom = false;
    boolean next = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        getDataFromIntent();
        init();
        eventClick();


    }

    private void eventClick() {
//        final Handler handler = new Handler();
//        handler.postDelayed(new )
        if(adaptersong.getItem(0) !=null){
            if(songs.size()> 0){
//                fragment_diaNhac.Playnhac(songs.get(0).getSongImageUrl());
            }
        }
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.iconplay);
                }
                else {
                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.iconpause);
                }
            }
        });
        btnRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(repeat == false){
                    if(checkrandom ==true){
                        checkrandom = false;
                        btnRepeat.setImageResource(R.drawable.iconsyned);
                        btnRepeat.setImageResource(R.drawable.iconsuffle);
                    }
                    btnRepeat.setImageResource(R.drawable.iconsyned);
                    repeat = true;
                } else {
                    btnRepeat.setImageResource(R.drawable.iconrepeat);
                    repeat = false;
                }
            }
        });
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkrandom == false){
                    if(repeat ==true){
                        repeat = false;
                        btnRandom.setImageResource(R.drawable.iconshuffled);
                        btnRandom.setImageResource(R.drawable.iconrepeat);
                    }
                    btnRandom.setImageResource(R.drawable.iconshuffled);
                    checkrandom = true;
                } else {
                    btnRandom.setImageResource(R.drawable.iconsuffle);
                    checkrandom = false;
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(songs.size()> 0){
                    if(mediaPlayer.isPlaying()||mediaPlayer!=null){
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    if(position<songs.size()){
                        btnPlay.setImageResource(R.drawable.iconpause);
                        position++;
                        if(repeat==true){
                            if(position == 0){
                                position = songs.size();
                            }
                            position -=1;
                        }
                        if (checkrandom ==true){
                            Random random = new Random();
                            int index = random.nextInt(songs.size());
                            if(index == position){
                                position = index-1;
                            }
                            position=index;
                        }
                        if(position> (songs.size() -1)){
                            position = 0;
                        }
                        new PlayMp3().equals(songs.get(position).getSongLink());
//                        fragment_diaNhac.Playnhac(songs.get(position).getSongImageUrl());
                        getSupportActionBar().setTitle(songs.get(position).getSongName());


                    }
                }
                btnPreview.setClickable(false);
                btnNext.setClickable(false);
//                Handler handler = new Handler() {
//                }
            }
        });
        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(songs.size()> 0){
                    if(mediaPlayer.isPlaying()||mediaPlayer!=null){
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    if(position<songs.size()){
                        btnPlay.setImageResource(R.drawable.iconpause);
                        position--;
                        if(position < 0){
                            position =songs.size()-1;
                        }
                        if(repeat==true){
                            position +=1;
                        }
                        if (checkrandom ==true){
                            Random random = new Random();
                            int index = random.nextInt(songs.size());
                            if(index == position){
                                position = index-1;
                            }
                            position=index;
                        }

                        new PlayMp3().equals(songs.get(position).getSongLink());
//                        fragment_diaNhac.Playnhac(songs.get(position).getSongImageUrl());
                        getSupportActionBar().setTitle(songs.get(position).getSongName());


                    }
                }
                btnPreview.setClickable(false);
                btnNext.setClickable(false);
//                Handler handler = new Handler() {
//                }
            }
        });
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        songs.clear();
        if(intent != null) {
            if (intent.hasExtra("playsong")) {
                Song song = intent.getParcelableExtra("playsong");
                songs.add(song);
                Log.d("playsong", song.getSongName());
            }
            if (intent.hasExtra("playListSong")) {
                ArrayList<Song> playListSong = intent.getParcelableArrayListExtra("playListSong");
//                songs = playListSong;
                for(int i=0; i<playListSong.size(); i++){
//                    Log.d("playListSong", playListSong.get(i).getSongName());
                    songs.add(playListSong.get(i));
                }
//                    Log.d("playListSong", songs.toString());

            }
        }
    }

    private void init() {
        viewPagerplaymusic = findViewById(R.id.viewpaperplaymusic);
        seekBar = findViewById(R.id.seekBar);
        tvTimeRun = findViewById(R.id.tvTimeRun);
        tvTimeAll = findViewById(R.id.tvTimeAll);
//        imgCD = findViewById(R.id.imgCD);
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
                mediaPlayer.stop();
                songs.clear();
            }
        });
        toolbarplaymusic.setTitleTextColor(Color.WHITE);
        fragment_diaNhac = new Fragment_DiaNhac();
        listPlayMusicFragment = new ListPlayMusicFragment();
        adaptersong= new ViewPaperPlayListMusic(getSupportFragmentManager());
        adaptersong.AddFragment(fragment_diaNhac);
        adaptersong.AddFragment(listPlayMusicFragment);
        viewPagerplaymusic.setAdapter(adaptersong);
        fragment_diaNhac = (Fragment_DiaNhac) adaptersong.getItem(0);
        if(songs.size()> 0){
            getSupportActionBar().setTitle(songs.get(0).getSongName());
            new PlayMp3().execute(songs.get(0).getSongLink());
            btnPlay.setImageResource(R.drawable.iconpause);
        }
    }

    class PlayMp3 extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String song) {
            super.onPostExecute(song);
            try{
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                    }
                });
                mediaPlayer.setDataSource(song);
                mediaPlayer.prepare();
            } catch (IOException e){
                e.printStackTrace();
            }
            mediaPlayer.start();
            TimeSong();
        }

    }

    private void TimeSong() {
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("mm:ss");
        tvTimeAll.setText(simpleFormatter.format(mediaPlayer.getDuration()));
        seekBar.setMax(mediaPlayer.getDuration());
    }
}