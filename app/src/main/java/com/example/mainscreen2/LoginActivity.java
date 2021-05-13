package com.example.mainscreen2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity{

    private EditText name, password, passError;
    private Button login;
    private TextView create_acc;
    private boolean isPasswordValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        name = (EditText) findViewById(R.id.edt_name);
        password = (EditText) findViewById(R.id.edt_pass);
        login = (Button) findViewById(R.id.btn_logIn);
        create_acc = (TextView) findViewById(R.id.tv_create);

//        passError = (TextInputLayout) findViewById(R.id.passError);

        login.setOnClickListener(new View.OnClickListener() {

            // public void onClick(View v) {
//                SetValidation();
//            }
            @Override
            public void onClick(View v) {
                // chuyen den Trang chu
                Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });

        create_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chuyen den Trang Dang Ky
                Intent intent2 = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent2);
            }
        });
    }

    public void SetValidation() {
        // Check for a valid password.
//        if (password.getText().toString().isEmpty()) {
//            passError.setError(getResources().getString(R.string.password_error));
//            isPasswordValid = false;
//        } else if (password.getText().length() < 6) {
//            passError.setError(getResources().getString(R.string.error_invalid_password));
//            isPasswordValid = false;
//        } else  {
//            isPasswordValid = true;
//            passError.setErrorEnabled(false);
//        }
//
//        if (isPasswordValid) {
//            Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();
//
//        }

    }

}

