package com.desafiolatam.desafioface.views.login;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.desafiolatam.desafioface.R;


public class LoginActivity extends AppCompatActivity implements SessionCallback {

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

                new Signin(LoginActivity.this).toServer(email, pass);

            }
        });

    }

    private void restoredView() {
        mailEt.setError(null);
        passEt.setError(null);
        mailWrapper.setVisibility(View.VISIBLE);
        passWrapper.setVisibility(View.VISIBLE);
        button.setVisibility(View.VISIBLE);
    }

    @Override
    public void requiredField() {
        restoredView();
        mailEt.setError("REQUERIDO");
        passEt.setError("REQUERIDO");
    }

    @Override
    public void mailFormat() {
        restoredView();
        mailEt.setError("FORMATO INCORRECTO");
    }

    @Override
    public void success() {
        Toast.makeText(this, "FUNCIONA", Toast.LENGTH_LONG).show();
    }

    @Override
    public void failure() {
        restoredView();
        Toast.makeText(this, "Mail o password incorrecto", Toast.LENGTH_LONG).show();
    }
}
