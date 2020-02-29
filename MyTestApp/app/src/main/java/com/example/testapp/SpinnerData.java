package com.example.testapp;

import java.util.ArrayList;

public class SpinnerData {
    public static ArrayList SpinnerData() {

        ArrayList<String> reasonsList = new ArrayList();

        reasonsList.add("Причина простоя...");
        reasonsList.add("1.Простой из-за нехватки запчастей");
        reasonsList.add("2.Простой из-за отсутствия водителя");
        reasonsList.add("3.Простой из-за отсутствия работы");
        reasonsList.add("4.Простой по причине ремонта");

        return reasonsList;

    }
}
