package com.example.testapp.domain;

public class LastDowntimeUseCaseEntity {

    private String description;
    private String period;

    public LastDowntimeUseCaseEntity(String description, String period){
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
