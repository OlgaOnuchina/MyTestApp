package com.sample.core.repository.impl;

import com.sample.core.dto.ResultLogin;
import com.sample.core.repository.LoginRepository;

import io.reactivex.Observable;

public class LoginRepositoryImpl implements LoginRepository {

    private static LoginRepositoryImpl loginRepository;

    public static LoginRepository instance() {
        if(loginRepository == null) {
            loginRepository = new LoginRepositoryImpl();
        }
        return loginRepository;
    }

    @Override
    public Observable<ResultLogin> login(String userName, String password) {
        return Observable.just(new ResultLogin("Ok", ""));
    }
}
