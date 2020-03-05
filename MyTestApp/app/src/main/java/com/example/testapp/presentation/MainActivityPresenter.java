package com.example.testapp.presentation;

import android.view.View;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.testapp.domain.AuthorizationUse;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainView> {

    private AuthorizationUse authorizationUse;

    public MainActivityPresenter(AuthorizationUse authorizationUse){
        this.authorizationUse = authorizationUse;
    }

}
