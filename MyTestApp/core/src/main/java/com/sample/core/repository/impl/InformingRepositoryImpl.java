package com.sample.core.repository.impl;

import com.sample.core.Core;
import com.sample.core.DowntimeService;
import com.sample.core.dto.InfoForklift;
import com.sample.core.dto.LastDowntime;
import com.sample.core.dto.ReasonDowntime;
import com.sample.core.repository.InformingRepository;

import java.util.List;

import io.reactivex.Observable;

public class InformingRepositoryImpl implements InformingRepository {

    private static InformingRepositoryImpl InformingRepository;
    private DowntimeService downtimeService;

    private InformingRepositoryImpl() {
        DowntimeService downtimeService = Core.instance().getDowntimeService();
    }

    public static InformingRepository instance() {
        if(InformingRepository == null) {
            InformingRepository = new InformingRepositoryImpl();
        }
        return InformingRepository;
    }

    @Override
    public Observable<InfoForklift> getInfo(String idForklift) {
        return downtimeService.getInfo(idForklift);
    }

    @Override
    public Observable<List<LastDowntime>> getLastDowntime(String idForklift) {
        return downtimeService.getLastDowntime(idForklift);
    }

    @Override
    public Observable<List<ReasonDowntime>> getReasons() {
        return downtimeService.getReasons();
    }
}
