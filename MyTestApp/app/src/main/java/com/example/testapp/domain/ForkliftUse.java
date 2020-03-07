package com.example.testapp.domain;


import java.util.List;

public interface ForkliftUse {

    List<String> getReasonsList();

    String getInfoForklift();

    List<LastDowntimeUseCaseEntity> getLastDowntime();

    boolean addDowntime();

}
