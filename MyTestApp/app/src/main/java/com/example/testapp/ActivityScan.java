package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityScan extends AppCompatActivity implements View.OnClickListener{

    EditText barcode;
    Button scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        barcode = findViewById(R.id.barcode);
        scan = findViewById(R.id.scan);
        scan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.scan:
                Intent intent = new Intent(this, ActivityMenu.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}