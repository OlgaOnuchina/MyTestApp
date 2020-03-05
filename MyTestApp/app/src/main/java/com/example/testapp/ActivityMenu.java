package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.testapp.domain.ForkliftUse;
import com.example.testapp.domain.ForkliftUseImpl;
import com.example.testapp.presentation.MenuActivityPresenter;
import com.example.testapp.presentation.MenuView;


public class ActivityMenu extends AppCompatActivity
        implements View.OnClickListener, MenuView {

    TextView text_info;
    Button add_downtime;
    RecyclerView recyclerView;
    ProgressBar progressBar;

    @InjectPresenter
    MenuActivityPresenter presenter;

    @ProvidePresenter
    MenuActivityPresenter providePresenter() {
        return new MenuActivityPresenter(new ForkliftUseImpl());
    }

    private ForkliftUse forkliftUse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        text_info = findViewById(R.id.text_info);
        add_downtime = findViewById(R.id.add_downtime);
        add_downtime.setOnClickListener(this);
        recyclerView = findViewById(R.id.last_downtime);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        progressBar = findViewById(R.id.progressBar);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_downtime:
                Intent intent = new Intent(this, ActivityDowntime.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void setInfoText(String text) {
        text_info.setText(text);
    }

    @Override
    public void setAdapter(DowntimeAdapter downtimeAdapter) {
        recyclerView.setAdapter(downtimeAdapter);
    }
}
