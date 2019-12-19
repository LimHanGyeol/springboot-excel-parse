package com.example.albit_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AlbitTestApplication {



	public static void main(String[] args) {
		SpringApplication.run(AlbitTestApplication.class, args);
        TestService testService = new TestService();
		try {
            //testService.excelImport();
            List<Albit> list = testService.readExcelFile();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
