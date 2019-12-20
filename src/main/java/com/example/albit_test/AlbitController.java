package com.example.albit_test;

import com.example.albit_test.model.Albit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AlbitController {

    @Autowired
    AlbitService albitService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<Albit> excelDataLoad() {
        List<Albit> list = new ArrayList<>();
        try {
            list = albitService.readExcelFile();
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}