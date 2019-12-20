package com.example.albit_test;

import com.example.albit_test.model.Albit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class AlbitController {

    // C:\Users\HANGYEOL\Desktop\albit_test\src\main\resources\static\bbbb.xlsx
    @Autowired
    AlbitService albitService;

    @GetMapping("/")
    public String home() {
        try {
            List<Albit> list = albitService.readExcelFile();
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }
}