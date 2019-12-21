package com.example.albit_test.service;


import com.example.albit_test.dto.StatisticsDto;
import com.example.albit_test.model.Statistics;
import com.example.albit_test.repository.StatisticsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticsReadService {

    @Autowired
    private StatisticsRepository statisticsRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<StatisticsDto> getExcelDataList() {
        List<Statistics> excelDataList = statisticsRepository.findAll();
        return excelDataList.stream().map(excelData -> modelMapper.map(excelData, StatisticsDto.class))
                .collect(Collectors.toList());
    }



}
