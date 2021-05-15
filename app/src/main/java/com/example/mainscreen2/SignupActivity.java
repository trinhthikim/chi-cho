package com.example.mainscreen2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SignupActivity extends AppCompatActivity {

    private EditText name, email_1, password_1;
    private Button register;
    private TextView login_acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);

        name = (EditText) findViewById(R.id.edt_name);
        email_1 = (EditText) findViewById(R.id.edt_email);
        password_1 = (EditText) findViewById(R.id.edt_pass);
        register = (Button) findViewById(R.id.btn_register);
        login_acc = (TextView) findViewById(R.id.tv_login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username, email, password;
                username = String.valueOf(name.getText());
                email = String.valueOf(email_1.getText());
                password = String.valueOf(password_1.getText());

                if(!username.equals("") && !password.equals("") && !email.equals("")) {
                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[3];
                            field[0] = "username";
                            field[1] = "email";
                            field[2] = "password";
                            //Creating array for data
                            String[] data = new String[3];
                            data[0] = username;
                            data[1] = email;
                            data[2] = password;
                            PutData putData = new PutData("http://192.168.1.8/LoginRegister/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Sign Up Success")) {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        // chuyen den Trang đăng ký
                                        Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
                                        startActivity(intent1);
                                        finish();
                                    } else {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                }
                else {
                    Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                }
            }
        });


        login_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chuyen den Trang Dang Ky
                Intent intent2 = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent2);
            }
        });
    }



}
