package com.example.geektrust.entity;

import java.util.HashMap;
import java.util.Map;

public class Asset {


    int initialInvestment;
    int initialWeightage;


    int currentMonth;
    int sipAmount;


    public Asset(int initialInvestment, int initialWeightage) {
        this.initialInvestment = initialInvestment;
        this.initialWeightage = initialWeightage;
    }
    public int getInitialWeightage() {
        return initialWeightage;
    }

    public void setInitialWeightage(int initialWeightage) {
        this.initialWeightage = initialWeightage;
    }

    public int getSipAmount() {
        return sipAmount;
    }

    public void setSipAmount(int sipAmount) {
        this.sipAmount = sipAmount;
    }

    public int getInitialInvestment() {
        return initialInvestment;
    }

    public void setInitialInvestment(int initialInvestment) {
        this.initialInvestment = initialInvestment;
    }


}
