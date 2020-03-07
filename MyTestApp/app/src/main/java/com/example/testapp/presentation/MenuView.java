package com.example.testapp.presentation;

import com.arellomobile.mvp.MvpView;
import com.example.testapp.domain.LastDowntime;

import java.util.List;

public interface MenuView extends MvpView {
    void setInfoText(String text);
    void initRecycler(List<LastDowntime> listLastDowntime);
}
