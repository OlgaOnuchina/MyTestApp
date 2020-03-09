package com.sample.core.repository.impl;

import com.sample.core.dto.InfoForklift;
import com.sample.core.dto.LastDowntime;
import com.sample.core.dto.ReasonDowntime;
import com.sample.core.repository.InformingRepository;

import io.reactivex.Observable;

public class InformingRepositoryImpl implements InformingRepository {

    private static InformingRepositoryImpl InformingRepository;

    public static InformingRepository instance() {
        if(InformingRepository == null) {
            InformingRepository = new InformingRepositoryImpl();
        }
        return InformingRepository;
    }

    @Override
    public Observable<InfoForklift> getInfo(String idForklift) {
        return Observable.just(new InfoForklift("test"));
    }

    @Override
    public Observable<LastDowntime> getLastDowntime(String idForklift) {
        return Observable.just(new LastDowntime("01", "test1", "07.03.20 - 08.03.20"));
    }

    @Override
    public Observable<ReasonDowntime> getReasons() {
        return Observable.just(new ReasonDowntime("01", "reason1"));
    }
}
