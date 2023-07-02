package com.example.geektrust.entity;

import java.util.Objects;

public class Asset {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        return initialInvestment == asset.initialInvestment && initialWeightage == asset.initialWeightage && sipAmount == asset.sipAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(initialInvestment, initialWeightage, sipAmount);
    }

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
