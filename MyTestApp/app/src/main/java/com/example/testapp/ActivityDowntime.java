package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ActivityDowntime extends AppCompatActivity implements View.OnClickListener {

    TextView start_downtime;
    EditText start_date_downtime;
    EditText start_time_downtime;
    TextView finish_downtime;
    EditText finish_date_downtime;
    EditText finish_time_downtime;
    EditText comment;
    Button saveDowntime;
    Spinner reasons;
    ArrayList reasonsList = SpinnerData.SpinnerData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downtime);

        start_downtime = findViewById(R.id.start_downtime);
        start_date_downtime = findViewById(R.id.start_date_downtime);
        start_time_downtime = findViewById(R.id.start_time_downtime);

        //start_downtime.setInputType(InputType.TYPE_CLASS_DATETIME);
        finish_downtime = findViewById(R.id.finish_downtime);
        finish_date_downtime = findViewById(R.id.finish_date_downtime);
        finish_time_downtime = findViewById(R.id.finish_time_downtime);

        //finish_downtime.setInputType(InputType.TYPE_CLASS_DATETIME);
        comment = findViewById(R.id.comment);
        saveDowntime = findViewById(R.id.saveDowntime);
        saveDowntime.setOnClickListener(this);
        reasons = findViewById(R.id.reasons);

        ArrayAdapter<String> adapter  =  new  ArrayAdapter<String>(
                this, R.layout.spinner_design, reasonsList);

        adapter.setDropDownViewResource(R.layout.spinner_design);

        reasons.setAdapter(adapter);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saveDowntime:
                Toast toast = Toast.makeText(this, "Успешно сохранено", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,400);
                toast.show();
                break;
            default:
                break;

        }
    }

}
