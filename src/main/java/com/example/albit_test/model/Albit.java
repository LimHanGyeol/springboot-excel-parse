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
public class Albit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "period")
    private int period;

    @Column(name = "using_rate")
    private double using_rate;

    @Column(name = "smart_phone")
    private double smart_phone;

    @Column(name = "desktop_computer")
    private double desktop_computer;

    @Column(name = "notebook_computer")
    private double notebook_computer;

    @Column(name = "etc")
    private double etc;

    @Column(name = "smart_pad")
    private double smart_pad;

    public Albit() {
    }

    public Albit(int period, double using_rate, double smart_phone, double desktop_computer, double notebook_computer, double etc, double smart_pad) {
        this.period = period;
        this.using_rate = using_rate;
        this.smart_phone = smart_phone;
        this.desktop_computer = desktop_computer;
        this.notebook_computer = notebook_computer;
        this.etc = etc;
        this.smart_pad = smart_pad;
    }
}