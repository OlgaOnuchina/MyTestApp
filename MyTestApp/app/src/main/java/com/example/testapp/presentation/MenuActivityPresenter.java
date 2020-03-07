package com.example.testapp.presentation;


import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.testapp.domain.ForkliftUse;
import com.example.testapp.domain.LastDowntimeUseCaseEntity;

import java.util.List;

@InjectViewState
public class MenuActivityPresenter extends MvpPresenter<MenuView> {

    private ForkliftUse forkliftUse;
    private static final String TAG = "myLogs";

    public MenuActivityPresenter(ForkliftUse forkliftUse){
        this.forkliftUse = forkliftUse;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        Log.d(TAG, "onFirstViewAttach");
        getTextInfo();
        getLastDowntime();
    }

    private void getTextInfo(){
        String infoForklift = forkliftUse.getInfoForklift();
        getViewState().setInfoText(infoForklift);
    }

    private void getLastDowntime(){
        List<LastDowntimeUseCaseEntity> listLastDowntime = forkliftUse.getLastDowntime();
        getViewState().initRecycler(listLastDowntime);
    }

}
