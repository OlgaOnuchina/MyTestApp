package com.sample.core;

import com.sample.core.dto.InfoForklift;
import com.sample.core.dto.LastDowntime;
import com.sample.core.dto.ReasonDowntime;
import com.sample.core.dto.ResultLogin;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface DowntimeService {

    @GET(value = "/test")
    public Observable<ResultLogin> login(String userName, String password);

    @GET(value = "/getInfo")
    public Observable<InfoForklift> getInfo(String idForklift);

    @GET(value = "/getLastDowntime")
    public Observable<List<LastDowntime>> getLastDowntime(String idForklift);

    @GET(value = "/getReasons")
    public Observable<List<ReasonDowntime>> getReasons();

}
