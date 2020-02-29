package com.example.testapp.domain;


import java.util.List;

public interface ForkliftUse {

    public List<String> getReasonsList();

    public String getInfoForklift();

    public List<lastDowntime> getLastDowntime();

    public boolean addDowntime();

}
