package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityMenu extends AppCompatActivity implements View.OnClickListener {

    TextView text_info;
    Button add_downtime;
    RecyclerView recyclerView;
    ArrayList recyclerListData = RecyclerData.getRecyclerData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        text_info = findViewById(R.id.text_info);
        text_info.setText("Автопогрузчик № 06 TOYOTA");
        add_downtime = findViewById(R.id.add_downtime);
        add_downtime.setOnClickListener(this);
        recyclerView = findViewById(R.id.last_downtime);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);

        RecAdapter recAdapter = new RecAdapter(recyclerListData);
        recyclerView.setAdapter(recAdapter);



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
}
