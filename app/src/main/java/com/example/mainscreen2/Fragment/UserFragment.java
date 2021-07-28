package com.example.mainscreen2.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainscreen2.API.ApiService;
import com.example.mainscreen2.Adapter.PlaylistUserAdapter;
import com.example.mainscreen2.LoginActivity;
import com.example.mainscreen2.MainActivity;
import com.example.mainscreen2.Model.Playlist;
import com.example.mainscreen2.Model.User;
import com.example.mainscreen2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserFragment extends Fragment {
    View view;
    ImageView img_avatar;
    TextView name_user;
    LinearLayout favorite_song;
    LinearLayout favorite_album;
    TextView create_playlist;
    TextView edt_name;
    TextView edt_pass;
    Button logout;
    Playlist playlist;
    private User user = new User();
    private MainActivity mainActivity;

    PlaylistUserAdapter adapter;
    ArrayList<Playlist> playlists;

    RecyclerView rvSong;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user, container, false);

        mainActivity = (MainActivity) getActivity();
        user = mainActivity.user;
        mapping();

        setImg_avatar();

        create_playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogCreatePlaylist(Gravity.CENTER);
            }
        });
        edt_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogEditName(Gravity.BOTTOM);
            }
        });

        edt_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogEditPassword(Gravity.BOTTOM);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.user.setUserId(null);
                Intent intent = new Intent(mainActivity.getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        getData();
        return view;
    }
    private void mapping() {
        img_avatar = view.findViewById(R.id.img_avatar);
        name_user = view.findViewById(R.id.name_user);
        favorite_song = view.findViewById(R.id.favorite_song);
        favorite_album = view.findViewById(R.id.favorite_album);
        create_playlist = view.findViewById(R.id.create_playlist);
        edt_name = view.findViewById(R.id.edt_name);
        edt_pass = view.findViewById(R.id.edt_pass);
        logout = view.findViewById(R.id.logout);
        rvSong = view.findViewById(R.id.rvSong);
    }

    private void setImg_avatar() {
        if (TextUtils.equals(user.getUserId(), null))
        {
            Log.e("ID", "Khong chuyen duoc id user");
        }else {
            Log.e("ID", "User Id user chua load: " + user.toString());
            ApiService.apiService.getDataUser(user).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    user=response.body();
                    Log.e("ID", "User Id user: " + user.toString());
                    Picasso.with(getContext()).load(user.getUserAvatarUrl()).centerCrop().fit().into(img_avatar);
                    name_user.setText(user.getUsername());
                }
                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.d("ID", "Call Api Error");
                }
            });
        }

    }

    private void openDialogEditName(int gravity) {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_edit_name);

        Window window = dialog.getWindow();
        if(window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        if (Gravity.BOTTOM == gravity) {
            dialog.setCancelable(true);
        } else {
            dialog.setCancelable(false);
        }

        EditText edt_newName = dialog.findViewById(R.id.edt_newName);
        Button btn_submit = dialog.findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User newUser = new User(user.getUserId(), edt_newName.getText().toString(), user.getEmail(), user.getPassword());
                resetName(newUser);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void resetName(User newUser) {
        ApiService.apiService.resetName(newUser).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user=response.body();
                Log.d("resetUser", "ok name");
                getData();
                name_user.setText(user.getUsername());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getContext(), playlist.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openDialogEditPassword(int gravity) {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_edit_password);

        Window window = dialog.getWindow();
        if(window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        if (Gravity.BOTTOM == gravity) {
            dialog.setCancelable(true);
        } else {
            dialog.setCancelable(false);
        }

        EditText edt_newPass = dialog.findViewById(R.id.edt_newPass);
        Button btn_submit = dialog.findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User newUser = new User(user.getUserId(), user.getUsername(), user.getEmail(), edt_newPass.getText().toString());
                resetPassword(newUser);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void resetPassword(User newUser) {
        ApiService.apiService.resetPassword(newUser).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user=response.body();
                Log.d("resetUser", "ok");
                getData();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getContext(), playlist.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openDialogCreatePlaylist(int gravity) {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_center);

        Window window = dialog.getWindow();
        if(window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        EditText namePlaylist = dialog.findViewById(R.id.namePlaylist);
        Button btn_no_thank = dialog.findViewById(R.id.btn_no_thank);
        Button btn_ok = dialog.findViewById(R.id.btn_ok);

        btn_no_thank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playlist = new Playlist(namePlaylist.getText().toString(), user.getUserId());
                createPlayList();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void createPlayList() {
        ApiService.apiService.createPlayList(playlist).enqueue(new Callback<Playlist>() {
            @Override
            public void onResponse(Call<Playlist> call, Response<Playlist> response) {
                playlist=response.body();
                Log.d("PlaylistUser", "call api lan 2");
                getData();
            }

            @Override
            public void onFailure(Call<Playlist> call, Throwable t) {
                Toast.makeText(getContext(), playlist.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getData() {
        ApiService.apiService.loadPlayListUser(user).enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                Log.d("PlaylistUser", "Call Api Success");
                playlists = (ArrayList<Playlist>) response.body();
                adapter = new PlaylistUserAdapter(playlists, getContext(), user);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                linearLayoutManager.scrollToPosition(0);
                rvSong.setAdapter(adapter);
                rvSong.setLayoutManager(linearLayoutManager);

            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {
                Log.d("PlaylistUser", "Call Api Error");
            }
        });
    }
}
