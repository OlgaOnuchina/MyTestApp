package com.example.testapp.domain.impl;

import com.example.testapp.domain.InformingUseCase;
import com.example.testapp.domain.mapper.InfoForkliftMapper;
import com.example.testapp.domain.print.InfoForkliftPrint;
import com.sample.core.dto.InfoForklift;
import com.sample.core.dto.LastDowntime;
import com.sample.core.dto.ReasonDowntime;
import com.sample.core.repository.InformingRepository;
import com.sample.core.repository.impl.InformingRepositoryImpl;

import io.reactivex.Observable;

public class InformingUseCaseImpl implements InformingUseCase {

    private final InformingRepository informingRepository;
    private final InfoForkliftMapper infoForkliftMapper;

    public InformingUseCaseImpl() {
        this.informingRepository = InformingRepositoryImpl.instance();
        infoForkliftMapper = new InfoForkliftMapper();
    }

    @Override
    public Observable<InfoForklift> getInfo(String idForklift) {
         return informingRepository.getInfo(idForklift).map();

        //return Observable.just(new InfoForklift("test"));
    }

    private InfoForkliftPrint map(InfoForklift item){
        return infoForkliftMapper.map(item);
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
