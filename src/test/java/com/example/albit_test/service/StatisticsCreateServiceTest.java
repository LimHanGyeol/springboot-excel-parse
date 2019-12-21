package com.example.albit_test.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StatisticsCreateServiceTest {

    @Autowired
    private StatisticsCreateService statisticsCreateService;

    @Test
    private void readExcelFileTests() {
        try {
            assertNotNull(statisticsCreateService.readExcelFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    private void indexDataVaildTests() {
        assertSame(statisticsCreateService.indexDataVaild("-"),"-");
    }
}