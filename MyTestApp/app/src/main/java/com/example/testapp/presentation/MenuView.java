package com.example.testapp.presentation;

import com.arellomobile.mvp.MvpView;
import com.example.testapp.DowntimeAdapter;

public interface MenuView extends MvpView {
    void setInfoText(String text);
    void setAdapter(DowntimeAdapter downtimeAdapter);
}
