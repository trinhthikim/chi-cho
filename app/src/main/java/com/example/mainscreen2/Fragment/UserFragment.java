package com.example.mainscreen2.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mainscreen2.LoginActivity;
import com.example.mainscreen2.MainActivity;
import com.example.mainscreen2.R;

import static android.content.Context.MODE_PRIVATE;

public class UserFragment extends Fragment {
    View view;
    ImageView img_avatar;
    LinearLayout favorite_song;
    LinearLayout favorite_album;
    LinearLayout create_playlist;
    LinearLayout edt_name;
    LinearLayout edt_pass;
    Button logout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user, container, false);
        Into();
        mapping();
        return view;
    }
    private void mapping() {
        img_avatar = view.findViewById(R.id.img_avatar);
        favorite_song = view.findViewById(R.id.favorite_song);
        favorite_album = view.findViewById(R.id.favorite_album);
        create_playlist = view.findViewById(R.id.create_playlist);
        edt_name = view.findViewById(R.id.edt_name);
        edt_pass = view.findViewById(R.id.edt_pass);
        logout = view.findViewById(R.id.logout);
    }
    private void Into() {

    }
}
