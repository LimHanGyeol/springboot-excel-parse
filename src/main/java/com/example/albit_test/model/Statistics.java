package com.example.albit_test.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "albit_data")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "period")
    private int period;

    @Column(name = "using_rate")
    private double usingRate;

    @Column(name = "smart_phone")
    private double smartPhone;

    @Column(name = "desktop_computer")
    private double desktopComputer;

    @Column(name = "notebook_computer")
    private double notebookComputer;

    @Column(name = "etc")
    private double etc;

    @Column(name = "smart_pad")
    private double smartPad;

    public Statistics() {
    }

    public Statistics(int period, double usingRate, double smartPhone, double desktopComputer, double notebookComputer, double etc, double smartPad) {
        this.period = period;
        this.usingRate = usingRate;
        this.smartPhone = smartPhone;
        this.desktopComputer = desktopComputer;
        this.notebookComputer = notebookComputer;
        this.etc = etc;
        this.smartPad = smartPad;
    }
}