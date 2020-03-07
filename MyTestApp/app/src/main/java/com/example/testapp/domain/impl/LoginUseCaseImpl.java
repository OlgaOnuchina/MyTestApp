package com.example.testapp.domain.impl;

import com.example.testapp.domain.LoginUseCase;
import com.sample.core.dto.ResultLogin;
import com.sample.core.repository.LoginRepository;
import com.sample.core.repository.impl.LoginRepositoryImpl;

import io.reactivex.Observable;

public class LoginUseCaseImpl implements LoginUseCase {

    private final LoginRepository loginRepository;

    public LoginUseCaseImpl() {
        this.loginRepository = LoginRepositoryImpl.instance();
    }

    @Override
    public Observable<ResultLogin> login(String userName, String password) {
        return new LoginRepositoryImpl().login(userName, password);
    }
}
