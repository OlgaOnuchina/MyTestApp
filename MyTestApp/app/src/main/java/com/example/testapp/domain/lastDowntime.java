package com.example.testapp.domain;

public class lastDowntime {

    private String description;
    private String period;

    public lastDowntime(String description, String period){
        this.description = description;
        this.period = period;
    }

    public String getDesc(){
        return this.description;
    }

    public String getPeriod(){
        return this.period;
    }

}
