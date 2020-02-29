package com.example.testapp;

import java.util.ArrayList;

public class RecyclerData {

    private String description;
    private String period;

    public RecyclerData(String description, String period){
        this.description = description;
        this.period = period;
    }

    public String getDesc(){
        return this.description;
    }

    public String getPeriod(){
        return this.period;
    }

    public static ArrayList<RecyclerData> getRecyclerData (){

        ArrayList<RecyclerData> recyclerListData = new ArrayList();

        recyclerListData.add(new RecyclerData("Простой из-за отсутствия работы, 18 мин.","04.02.2020 7:52:03 - 04.02.2020 8:10:00"));
        recyclerListData.add(new RecyclerData("Простой из-за нехватки запчастей, 1ч. 50 мин.","03.02.2020 14:07:30 - 03.02.2020 15:59:56"));
        recyclerListData.add(new RecyclerData("Простой по причине ремонта, 26 мин.","03.02.2020 8:12:00 - 03.02.2020 8:38:20"));
        recyclerListData.add(new RecyclerData("Простой из-за отсутствия работы, 3 ч.","02.02.2020 17:19:00 - 02.02.2020 20:01:11"));
        recyclerListData.add(new RecyclerData("Простой из-за нехватки запчастей, 5 ч.","02.02.2020 10:00:16 - 02.02.2020 15:00:00"));
        recyclerListData.add(new RecyclerData("Простой из-за отсутствия водителя, 3 мин.","01.02.2020 8:00:01 - 01.02.2020 8:04:26"));

        return recyclerListData;
    }

}
