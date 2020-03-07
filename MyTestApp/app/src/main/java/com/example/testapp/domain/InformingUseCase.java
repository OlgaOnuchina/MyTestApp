package com.example.testapp.domain;

import com.sample.core.dto.InfoForklift;
import com.sample.core.dto.LastDowntime;
import com.sample.core.dto.ReasonDowntime;

import io.reactivex.Observable;

public interface InformingUseCase {
    Observable<InfoForklift> getInfo(String idForklift);
    Observable<LastDowntime> getLastDowntime(String idForklift);
    Observable<ReasonDowntime> getReasons();
}
