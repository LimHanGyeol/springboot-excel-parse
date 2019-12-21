package com.example.albit_test.controller;

import com.example.albit_test.dto.StatisticsDto;
import com.example.albit_test.service.StatisticsReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatisticsController {

    @Autowired
    StatisticsReadService statisticsReadService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<StatisticsDto> excelDataLoad() {
        return statisticsReadService.getExcelDataList();
    }


}