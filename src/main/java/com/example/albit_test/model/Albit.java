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
    int id;

    @Column(name = "period")
    int period;

    @Column(name = "using_rate")
    double using_rate;

    @Column(name = "smart_phone")
    double smart_phone;

    @Column(name = "desktop_computer")
    double desktop_computer;

    @Column(name = "notebook_computer")
    double notebook_computer;

    @Column(name = "etc")
    double etc;

    @Column(name = "smart_pad")
    double smart_pad;

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