package com.example.testapp.presentation;

import android.view.View;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.testapp.domain.ForkliftUse;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainView> {

    private ForkliftUse forkliftUse;

    public MainActivityPresenter(ForkliftUse forkliftUse){
        this.forkliftUse = forkliftUse;
    }


}
