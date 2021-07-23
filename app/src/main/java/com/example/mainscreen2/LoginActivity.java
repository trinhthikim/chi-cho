package com.example.mainscreen2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.mainscreen2.API.ApiService;
import com.example.mainscreen2.Model.User;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity{

    EditText email, password;
    Button login;
    TextView create_acc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        init();
        setClick();
    }

    private void init() {
        email = findViewById(R.id.edt_name);
        password = findViewById(R.id.edt_pass);
        login = findViewById(R.id.btn_logIn);
        create_acc = findViewById(R.id.tv_create);
    }

    private void setClick() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textEmail=email.getText().toString();
                String textPassword=password.getText().toString();
                if (TextUtils.isEmpty(textEmail) && TextUtils.isEmpty(textPassword)) {
                    Toast.makeText(LoginActivity.this, "Bạn phải điền đầy đủ các trường", Toast.LENGTH_SHORT).show();
                } else {
                    User user=new User(textEmail, textPassword);
                    setLogin(user);
                }
            }
        });
        create_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chuyen den Trang Dang Ky
                Intent intent2 = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent2);
            }
        });
    }

    private void setLogin(User user) {
        ApiService.apiService.login(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                Toast.makeText(LoginActivity.this, user.getUserId(), Toast.LENGTH_SHORT).show();
                if(!user.getUserId().equals("0")){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("ID", user.getUserId());
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Signup", t.getLocalizedMessage());
            }
        });
    }
}

