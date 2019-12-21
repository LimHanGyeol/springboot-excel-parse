package com.example.albit_test;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AlbitTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlbitTestApplication.class, args);
	}

	/**
	 * Model Mapper
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
