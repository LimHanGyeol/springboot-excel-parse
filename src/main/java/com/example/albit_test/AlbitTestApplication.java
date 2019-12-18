package com.example.albit_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlbitTestApplication {



	public static void main(String[] args) {
		SpringApplication.run(AlbitTestApplication.class, args);
        TestService testService = new TestService();
		try {
            testService.excelImport();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
