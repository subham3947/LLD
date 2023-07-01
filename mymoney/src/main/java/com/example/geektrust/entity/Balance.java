package com.example.geektrust.entity;

public class Balance {

    int equityAmount;
    int debtAmount;
    int goldAmount;

    public Balance(int equityAmount, int debtAmount, int goldAmount) {
        this.equityAmount = equityAmount;
        this.debtAmount = debtAmount;
        this.goldAmount = goldAmount;
    }
    public int getEquityAmount() {
        return equityAmount;
    }

    public void setEquityAmount(int equityAmount) {
        this.equityAmount = equityAmount;
    }

    public int getDebtAmount() {
        return debtAmount;
    }

    public void setDebtAmount(int debtAmount) {
        this.debtAmount = debtAmount;
    }

    public int getGoldAmount() {
        return goldAmount;
    }

    public void setGoldAmount(int goldAmount) {
        this.goldAmount = goldAmount;
    }


}
