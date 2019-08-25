package com.controller;

import com.model.Result;
import com.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ResultController {
    private static String filterNumber = "";

    @Autowired
    private ResultService resultService;

    @GetMapping("/results")
    public List<Result> getAllResults() {
        return resultService.findAll();
    }

    @GetMapping("/tax")
    public Double getTax() {
        return resultService.showFinalTax().getResult();
    }

    @PostMapping("/calculator")
    public void createResult(@Valid @RequestBody Result r) {
        resultService.save(resultService.calculator(r));
    }

    @PostMapping("/myfilter")
    public void filter(@Valid @RequestBody String number) {
        filterNumber = number;
    }

    @GetMapping("/filter")
    public List<Result> taxFilter() {
        switch (filterNumber) {
            case "1":
                return resultService.taxFilter();
            case "2":
                return resultService.taxFilter1();

            case "3":
                return resultService.taxFilter2();
        }
        return null;
    }
}


