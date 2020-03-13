package com.example.testapp.presentation;

import com.arellomobile.mvp.MvpView;
import com.example.testapp.domain.print.LastDowntimePrint;

import java.util.List;

public interface MenuView extends MvpView {
    void setInfoText(String text);

    void initRecycler(List<LastDowntimePrint> listLastDowntimePrint);
}
