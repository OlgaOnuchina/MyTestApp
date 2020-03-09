package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.testapp.domain.ForkliftUse;
import com.example.testapp.domain.ForkliftUseImpl;
import com.example.testapp.domain.LastDowntimeUseCaseEntity;
import com.example.testapp.presentation.MenuActivityPresenter;
import com.example.testapp.presentation.MenuView;

import java.util.List;


public class ActivityMenu extends MvpAppCompatActivity
        implements View.OnClickListener, MenuView {

    TextView text_info;
    Button add_downtime;
    RecyclerView recyclerView;
    ProgressBar progressBar;

    private static final String TAG = "myLogs";

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
    public void initRecycler(List<LastDowntimeUseCaseEntity> listLastDowntimeUseCaseEntity) {
        DowntimeAdapter downtimeAdapter = new DowntimeAdapter(listLastDowntimeUseCaseEntity);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(downtimeAdapter);
        progressBar.setVisibility(View.GONE);
    }
}
