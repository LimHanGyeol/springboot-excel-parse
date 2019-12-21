package com.example.albit_test.controller;

import com.example.albit_test.AlbitDto;
import com.example.albit_test.service.AlbitReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlbitController {

    @Autowired
    AlbitReadService albitReadService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<AlbitDto> excelDataLoad() {
        List<AlbitDto> list = albitReadService.getExcelDataList();
        System.out.println(list);
        return list;
    }
}