package com.example.mainscreen2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mainscreen2.Model.Album;

public class ListSongActivity extends AppCompatActivity {

    Album album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_song);
        DataIntent();
    }

    private void DataIntent(){
        Intent intent = getIntent();
        if(intent != null) {
            if (intent.hasExtra("album")) {
                album = (Album) intent.getSerializableExtra("album");
                Toast.makeText(this, album.getAlbumName(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}