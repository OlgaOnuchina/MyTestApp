package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testapp.domain.ForkliftUse;
import com.example.testapp.domain.ForkliftUseImpl;
import com.example.testapp.domain.lastDowntime;

import java.util.ArrayList;
import java.util.List;

public class ActivityMenu extends AppCompatActivity implements View.OnClickListener {

    TextView text_info;
    Button add_downtime;
    RecyclerView recyclerView;

    private ForkliftUse forkliftUse;
    //ArrayList recyclerListData = RecyclerData.getRecyclerData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initRepo();
        text_info = findViewById(R.id.text_info);
        String infoForklift = forkliftUse.getInfoForklift();
        text_info.setText(infoForklift);
        add_downtime = findViewById(R.id.add_downtime);
        add_downtime.setOnClickListener(this);
        recyclerView = findViewById(R.id.last_downtime);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);

        List<lastDowntime> recyclerListData = forkliftUse.getLastDowntime();
        RecAdapter recAdapter = new RecAdapter(recyclerListData);
        recyclerView.setAdapter(recAdapter);

    }

    private void initRepo() {
        forkliftUse = new ForkliftUseImpl();
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
