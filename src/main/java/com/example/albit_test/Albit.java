package com.example.albit_test;

import java.util.Date;

public class Albit {

    String name;
    String birthDate;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Albit{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
