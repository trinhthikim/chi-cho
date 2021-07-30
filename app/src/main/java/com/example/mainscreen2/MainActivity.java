package com.example.mainscreen2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mainscreen2.API.ApiService;
import com.example.mainscreen2.Adapter.ViewPagerAdapter;
import com.example.mainscreen2.Fragment.HomeFragment;
import com.example.mainscreen2.Model.User;
import com.example.mainscreen2.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    private EditText edtName;
    public User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            Into();
            anhxa();
            setClick();
            setUpViewPager();

    }

    private void Into() {
        Intent intent = getIntent();
        user.setUserId(intent.getStringExtra("ID"));
        if(TextUtils.equals(user.getUserId(), null)){
            intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }else {
            loadData();
        }
    }

    private void setClick() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                       viewPager.setCurrentItem(0);
                        break;
                    case R.id.action_search:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.action_user:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.action_setting:
                        viewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
    }

    private void anhxa() {
        bottomNavigationView = findViewById(R.id.bottom_nav);
        viewPager = findViewById(R.id.view_pager);
    }

    private void setUpViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.action_user).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.action_setting).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void loadData() {
        ApiService.apiService.getDataUser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user= response.body();
                Log.e("ID", "Main Id user: " + user.toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
//                Toast.makeText(MainActivity.this, t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                Log.e("ID", "get data user fail: " + t.getLocalizedMessage());
            }
        });
    }

}