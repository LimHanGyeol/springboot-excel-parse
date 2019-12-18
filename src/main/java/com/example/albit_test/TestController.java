package com.example.albit_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    // C:\Users\HANGYEOL\Desktop\albit_test\src\main\resources\static\bbbb.xlsx
    @Autowired
    TestService testService;

    @GetMapping("/")
    public String home() {

        return "index";
    }
}