package com.example.testapp.domain;


import com.example.testapp.domain.print.LastDowntimePrint;

import java.util.List;

public interface ForkliftUse {

    List<String> getReasonsList();

    String getInfoForklift();

    List<LastDowntimePrint> getLastDowntime();

    boolean addDowntime();

}
