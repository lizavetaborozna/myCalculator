package com.service;

import com.model.Result;

import java.util.List;

public interface ResultService {
    List<Result> findAll();

    Result showFinalTax();

    List<Result> taxFilter();

    List<Result> taxFilter1();

    List<Result> taxFilter2();

    void save(Result result);

    Result calculator(Result r);

}
