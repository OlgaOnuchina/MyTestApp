package com.example.testapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.testapp.domain.ForkliftUse;
import com.example.testapp.domain.ForkliftUseImpl;
import com.example.testapp.presentation.DowntimeActivityPresenter;
import com.example.testapp.presentation.DowntimeView;

import java.util.Calendar;
import java.util.List;


public class ActivityDowntime extends MvpAppCompatActivity implements View.OnClickListener, DowntimeView {

    EditText start_date_downtime;
    Button buttonDateStart;
    EditText finish_date_downtime;
    Button buttonDateFinish;
    Spinner reasons;
    EditText comment;
    Button saveDowntime;
    ArrayAdapter<String> adapter;

    @InjectPresenter
    DowntimeActivityPresenter presenter;

    @ProvidePresenter
    DowntimeActivityPresenter providePresenter() {
        return new DowntimeActivityPresenter(new ForkliftUseImpl());
    }

    private ForkliftUse forkliftUse;

    Calendar dateAndTime = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downtime);

        start_date_downtime = findViewById(R.id.start_date_downtime);
        finish_date_downtime = findViewById(R.id.finish_date_downtime);
        buttonDateStart = findViewById(R.id.buttonDateStart);
        buttonDateFinish = findViewById(R.id.buttonDateFinish);
        buttonDateStart.setOnClickListener(this);
        buttonDateFinish.setOnClickListener(this);
        setInitialDateTimeStart();
        setInitialDateTimeFinish(true);

        comment = findViewById(R.id.comment);
        saveDowntime = findViewById(R.id.saveDowntime);
        saveDowntime.setOnClickListener(this);
        reasons = findViewById(R.id.reasons);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saveDowntime:
                Toast toast = Toast.makeText(this, "Успешно сохранено", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,400);
                toast.show();
                break;
            case R.id.buttonDateStart:
                setDateStart(start_date_downtime);
                break;
            case R.id.buttonDateFinish:
                setDateFinish(finish_date_downtime);
                break;
            default:
                break;
        }
    }

    @Override
    public void setAdapter(List<String> reasonsList) {
        adapter = new ArrayAdapter<String>(this, R.layout.spinner_design, reasonsList);
        reasons.setAdapter(adapter);
    }

    private void setInitialDateTimeStart() {
        start_date_downtime.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                        | DateUtils.FORMAT_SHOW_TIME));
    }

    private void setInitialDateTimeFinish(boolean start) {

        if (start) {
            finish_date_downtime.setText(start_date_downtime.getText());
        }
        else {
            finish_date_downtime.setText(DateUtils.formatDateTime(this,
                    dateAndTime.getTimeInMillis(),
                    DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                            | DateUtils.FORMAT_SHOW_TIME));
        }
    }


    public void setDateStart(View v) {
        new DatePickerDialog(ActivityDowntime.this, dStart,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    public void setDateFinish(View v) {
        new DatePickerDialog(ActivityDowntime.this, dFinish,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    public void setTimeStart(View v) {
        new TimePickerDialog(ActivityDowntime.this, tStart,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true)
                .show();
    }

    public void setTimeFinish(View v) {
        new TimePickerDialog(ActivityDowntime.this, tFinish,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true)
                .show();
    }

    DatePickerDialog.OnDateSetListener dStart = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            //setInitialDateTimeStart();
            setTimeStart(start_date_downtime);
        }
    };

    DatePickerDialog.OnDateSetListener dFinish = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            //setInitialDateTimeFinish();
            setTimeFinish(finish_date_downtime);
        }
    };

    TimePickerDialog.OnTimeSetListener tStart = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            setInitialDateTimeStart();
            setInitialDateTimeFinish(true);
        }
    };

    TimePickerDialog.OnTimeSetListener tFinish = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            setInitialDateTimeFinish(false);
        }
    };

}
