package com.example.testapp.domain;

import java.util.ArrayList;
import java.util.List;

public class ForkliftUseImpl implements ForkliftUse {

    @Override
    public List<String> getReasonsList() {
        List<String> reasonsList = new ArrayList<>();

        reasonsList.add("Причина простоя...");
        reasonsList.add("1.Простой из-за нехватки запчастей");
        reasonsList.add("2.Простой из-за отсутствия водителя");
        reasonsList.add("3.Простой из-за отсутствия работы");
        reasonsList.add("4.Простой по причине ремонта");

        return reasonsList;
    }

    @Override
    public String getInfoForklift(){
        return "Автопогрузчик № 06 TOYOTA";
    }


    @Override
    public List<LastDowntimeUseCaseEntity> getLastDowntime() {
        List<LastDowntimeUseCaseEntity> recyclerListData = new ArrayList<>();

        recyclerListData.add(new LastDowntimeUseCaseEntity("Простой из-за отсутствия работы, 18 мин.","04.02.2020 7:52:03 - 04.02.2020 8:10:00"));
        recyclerListData.add(new LastDowntimeUseCaseEntity("Простой из-за нехватки запчастей, 1ч. 50 мин.","03.02.2020 14:07:30 - 03.02.2020 15:59:56"));
        recyclerListData.add(new LastDowntimeUseCaseEntity("Простой по причине ремонта, 26 мин.","03.02.2020 8:12:00 - 03.02.2020 8:38:20"));
        recyclerListData.add(new LastDowntimeUseCaseEntity("Простой из-за отсутствия работы, 3 ч.","02.02.2020 17:19:00 - 02.02.2020 20:01:11"));
        recyclerListData.add(new LastDowntimeUseCaseEntity("Простой из-за нехватки запчастей, 5 ч.","02.02.2020 10:00:16 - 02.02.2020 15:00:00"));
        recyclerListData.add(new LastDowntimeUseCaseEntity("Простой из-за отсутствия водителя, 3 мин.","01.02.2020 8:00:01 - 01.02.2020 8:04:26"));

        return recyclerListData;
    }

    @Override
    public boolean addDowntime() {
        return true;
    }

}
