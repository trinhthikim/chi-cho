package com.example.mainscreen2.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainscreen2.Adapter.PlayMusicAdapter;
import com.example.mainscreen2.PlayMusicActivity;
import com.example.mainscreen2.R;

public class ListPlayMusicFragment extends Fragment {
    View view;
    RecyclerView recyclerViewlistPlayMusic;
    PlayMusicAdapter playMusicAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_playmusic,container, false);
        recyclerViewlistPlayMusic = view.findViewById(R.id.recyclerviewlistplaymusic);
        if(PlayMusicActivity.songs.size()> 0){
            playMusicAdapter = new PlayMusicAdapter(getActivity(), PlayMusicActivity.songs);
            recyclerViewlistPlayMusic.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerViewlistPlayMusic.setAdapter(playMusicAdapter);
        }
        return view;
    }
}
