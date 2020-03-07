package com.example.testapp.domain;

import com.sample.core.dto.ResultLogin;

import io.reactivex.Observable;

public interface LoginUseCase {
    Observable<ResultLogin> login(String userName, String password);
}
