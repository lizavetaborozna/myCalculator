package com.controller;

import com.model.Result;
import com.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;

    @GetMapping("/results")
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    @GetMapping("/tax")
    public Double getTax(Result result) {
        return resultRepository.showFinalTax().getResult();
    }

    @PostMapping("/calculator")
    public void createResult(@Valid @RequestBody Result r) {
        resultRepository.save(resultRepository.calculator(r));
    }

    @GetMapping("/filter")
    public List<Result> taxFilter() {
        return resultRepository.taxFilter();
    }

    @GetMapping("/filter1")
    public List<Result> taxFilter1() {
        return resultRepository.taxFilter1();
    }

    @GetMapping("/filter2")
    public List<Result> taxFilter2() {
        return resultRepository.taxFilter2();
    }
}


