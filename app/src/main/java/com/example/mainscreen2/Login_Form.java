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

public class Login_Form extends AppCompatActivity{
//    EditText edtUserName, edtPass;
//    Button btnLogIn;

    EditText name, password;
    Button login;
    TextView create_acc;
    boolean isPasswordValid;
    TextInputLayout passError;

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
            @Override
            public void onClick(View v) {
                SetValidation();
            }
        });

        create_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(getApplicationContext(), Signup_Form.class);
                startActivity(intent);
            }
        });
    }

    public void SetValidation() {
        // Check for a valid password.
        if (password.getText().toString().isEmpty()) {
            passError.setError(getResources().getString(R.string.password_error));
            isPasswordValid = false;
        } else if (password.getText().length() < 6) {
            passError.setError(getResources().getString(R.string.error_invalid_password));
            isPasswordValid = false;
        } else  {
            isPasswordValid = true;
            passError.setErrorEnabled(false);
        }


    }

//    private void anhxa() {
//
//        edtUserName = (EditText)findViewById(R.id.edt_name);
//        edtPass = (EditText)findViewById(R.id.edt_pass);
//        btnLogIn = (Button)findViewById(R.id.btn_logIn);
//    }
}

