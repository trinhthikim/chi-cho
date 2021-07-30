package com.example.mainscreen2.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mainscreen2.API.ApiService;
import com.example.mainscreen2.MainActivity;
import com.example.mainscreen2.Model.Banner;
import com.example.mainscreen2.Model.User;
import com.example.mainscreen2.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.animation.type.SlideAnimation;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    View view;
    private SliderLayout auto_slider;
    private ImageView img_avatar;
    private SearchView searchView;
    private User user = new User();
    private MainActivity mainActivity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container, false);

        anhxa();
        Into();
        mainActivity = (MainActivity) getActivity();
        user = mainActivity.user;
        setImg_avatar();

        return view;
    }

    private void anhxa() {
        img_avatar = view.findViewById(R.id.img_avatar);

    }

    private void Into() {
    }

    private void setImg_avatar() {
        if (TextUtils.equals(user.getUserId(), null))
        {
            Log.e("ID", "Khong chuyen duoc id user");
        }else {
            Log.e("ID", "Home Id user chua load: " + user.toString());
            ApiService.apiService.getDataUser(user).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    user=response.body();
                    Log.e("ID", "Home Id user: " + user.toString());
                    Picasso.with(getContext()).load(user.getUserAvatarUrl()).centerCrop().fit().into(img_avatar);
                }
                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.d("ID", "Call Api Error");
                }
            });
        }

    }


}
