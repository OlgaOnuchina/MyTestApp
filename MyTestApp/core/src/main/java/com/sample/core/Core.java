package com.sample.core;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Core {

    private static final String BASE_URL = "http://тут мне это писать не разрешают/";
    private Retrofit apiRetrofit;
    private static Core core;
    private DowntimeService downtimeService;

    public static Core instance() {
        if(core == null) {
            core = new Core();
        }
        return core;
    }

    public Core(){
        apiRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiRetrofit.create(downtimeService.getClass());
    }

    public DowntimeService getDowntimeService(){ return downtimeService; }
}
