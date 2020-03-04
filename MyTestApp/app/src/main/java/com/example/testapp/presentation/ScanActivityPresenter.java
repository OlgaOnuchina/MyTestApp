package com.example.testapp.presentation;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.testapp.domain.ForkliftUse;

@InjectViewState
public class ScanActivityPresenter extends MvpPresenter<ScanView> {
    private ForkliftUse forkliftUse;

    public ScanActivityPresenter(ForkliftUse forkliftUse){
        this.forkliftUse = forkliftUse;
    }

}
