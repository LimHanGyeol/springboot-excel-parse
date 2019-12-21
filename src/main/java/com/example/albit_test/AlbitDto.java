package com.example.albit_test;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlbitDto {

    private int id;
    private int period;
    private double using_rate;
    private double smart_phone;
    private double desktop_computer;
    private double notebook_computer;
    private double etc;
    private double smart_pad;
}
