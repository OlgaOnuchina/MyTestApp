package com.example.testapp.presentation;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.testapp.domain.ForkliftUse;

import java.util.List;

@InjectViewState
public class DowntimeActivityPresenter extends MvpPresenter<DowntimeView> {

    private ForkliftUse forkliftUse;

    public DowntimeActivityPresenter(ForkliftUse forkliftUse){
        this.forkliftUse = forkliftUse;
    }

    @Override
    protected void onFirstViewAttach(){
        getReasonsList();
    }

    private void getReasonsList(){
        List<String> reasonsList = forkliftUse.getReasonsList();
        getViewState().setAdapter(reasonsList);
    }
}
