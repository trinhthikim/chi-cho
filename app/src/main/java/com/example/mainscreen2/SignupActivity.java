package com.example.mainscreen2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    private EditText name, email, password, passError;
    private Button register;
    private TextView login_acc;
    private boolean isPasswordValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);

        name = (EditText) findViewById(R.id.edt_name);
        email = (EditText) findViewById(R.id.edt_email);
        password = (EditText) findViewById(R.id.edt_pass);
        register = (Button) findViewById(R.id.btn_register);
        login_acc = (TextView) findViewById(R.id.tv_login);

        register.setOnClickListener(new View.OnClickListener() {

            // public void onClick(View v) {
//                SetValidation();
//            }
            @Override
            public void onClick(View v) {
                // chuyen den Trang đăng ký
                Intent intent1 = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent1);
            }
        });

        login_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chuyen den Trang Dang Ky
                Intent intent2 = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent2);
            }
        });
    }
}
