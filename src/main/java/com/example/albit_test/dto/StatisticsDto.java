package com.example.albit_test.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StatisticsDto {

    private int id;
    private int period;
    private double usingRate;
    private double smartPhone;
    private double desktopComputer;
    private double notebookComputer;
    private double etc;
    private double smartPad;
}
