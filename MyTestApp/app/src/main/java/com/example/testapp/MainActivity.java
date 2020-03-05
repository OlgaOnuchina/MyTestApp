package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.testapp.domain.AuthorizationUseImpl;
import com.example.testapp.presentation.MainActivityPresenter;
import com.example.testapp.presentation.MainView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainView {

    @InjectPresenter
    MainActivityPresenter presenter;

    @ProvidePresenter
    MainActivityPresenter providePresenter() {
        return new MainActivityPresenter(new AuthorizationUseImpl());
    }

    TextView welcomeText;
    EditText userName;
    EditText password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeText = findViewById(R.id.welcome_text);
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.login:
                Intent intent = new Intent(this, ActivityScan.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
