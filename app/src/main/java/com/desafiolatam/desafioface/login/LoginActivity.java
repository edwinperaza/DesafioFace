package com.desafiolatam.desafioface.login;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.desafiolatam.desafioface.R;


public class LoginActivity extends AppCompatActivity {

    private TextInputLayout mailWrapper, passWrapper;
    private EditText mailEt, passEt;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        mailWrapper = findViewById(R.id.emailTil);
        passWrapper = findViewById(R.id.passwordTil);
        mailEt = findViewById(R.id.emailEt);
        passEt = findViewById(R.id.passwordEt);
        button = findViewById(R.id.signBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mailEt.getText().toString();
                String pass = passEt.getText().toString();
                mailWrapper.setVisibility(View.GONE);
                passWrapper.setVisibility(View.GONE);
                button.setVisibility(View.GONE);

                
            }
        });

    }

}
