package com.example.mainscreen2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mainscreen2.API.ApiService;
import com.example.mainscreen2.Model.User;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    View view;
    EditText username, email, password, repassword;
    Button register;
    TextView login_acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);

        init();
        setClick();
    }

    private void init(){
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        register = findViewById(R.id.btn_register);
        login_acc = findViewById(R.id.tv_login);
    }

    private void setSignup(User user){
        ApiService.apiService.signUp(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                if(!user.getUserId().equals("0")){
                    Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                    intent.putExtra("ID", user.getUserId());
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
//                Toast.makeText(SignupActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Signup", t.getLocalizedMessage());
            }
        });
    }

    private void setClick() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textUsername = username.getText().toString();
                String textEmail = email.getText().toString();
                String textPassword = password.getText().toString();
                String textRepassword = repassword.getText().toString();
                if (TextUtils.isEmpty(textUsername) && TextUtils.isEmpty(textEmail) &&
                        TextUtils.isEmpty(textPassword) &&TextUtils.isEmpty(textRepassword)){
                    Toast.makeText(SignupActivity.this, "Bạn phải điền đầy đủ các trường", Toast.LENGTH_SHORT).show();
                }else {
                    if (textPassword.equals(textRepassword) == false){
                        Toast.makeText(SignupActivity.this, "Nhập lại mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        User user = new User(textUsername, textEmail, textPassword);
                        setSignup(user);
                    }
                }

            }
        });
        login_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent2);
            }
        });
    }
}
