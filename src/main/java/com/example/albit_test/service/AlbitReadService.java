package com.example.albit_test.service;


import com.example.albit_test.AlbitDto;
import com.example.albit_test.model.Albit;
import com.example.albit_test.repository.AlbitRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbitReadService {

    @Autowired
    private AlbitRepository albitRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<AlbitDto> getExcelDataList() {
        List<Albit> excelDataList = albitRepository.findAll();
        return excelDataList.stream().map(excelData -> modelMapper.map(excelData, AlbitDto.class))
                .collect(Collectors.toList());
    }



}
