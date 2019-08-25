package com.service.impl;

import com.model.Result;
import com.repository.ResultRepository;
import com.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    ResultRepository resultRepository;

    @Override
    public List<Result> findAll() {
        return resultRepository.findAll();
    }

    @Override
    public Result showFinalTax() {
        return resultRepository.showFinalTax();
    }

    @Override
    public List<Result> taxFilter() {
        return resultRepository.taxFilter();
    }

    @Override
    public List<Result> taxFilter1() {
        return resultRepository.taxFilter1();
    }

    @Override
    public List<Result> taxFilter2() {
        return resultRepository.taxFilter2();
    }

    @Override
    public void save(Result result) {
        resultRepository.save(result);
    }

    @Override
    public Result calculator(Result r) {
        return resultRepository.calculator(r);
    }
}
