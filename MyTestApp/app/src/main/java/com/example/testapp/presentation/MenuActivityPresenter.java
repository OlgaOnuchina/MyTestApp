package com.example.testapp.presentation;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.testapp.DowntimeAdapter;
import com.example.testapp.domain.ForkliftUse;
import com.example.testapp.domain.LastDowntime;

import java.util.List;

@InjectViewState
public class MenuActivityPresenter extends MvpPresenter<MenuView> {

    private ForkliftUse forkliftUse;

    public MenuActivityPresenter(ForkliftUse forkliftUse){
        this.forkliftUse = forkliftUse;
    }

    public void getTextInfo(){
        String infoForklift = forkliftUse.getInfoForklift();
        getViewState().setInfoText(infoForklift);
    }

    public void getLastDowntime(){
        List<LastDowntime> listLastDowntime = forkliftUse.getLastDowntime();
        DowntimeAdapter downtimeAdapter = new DowntimeAdapter(listLastDowntime);
        getViewState().setAdapter(downtimeAdapter);
    }
}
