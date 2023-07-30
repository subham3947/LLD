package com.example.geektrust.entity;

import java.util.Map;

public class Loan {

    private String bankName;
    private final int principalAmount;
    private int amountToBeRepaid;



    private final int finalAmount;
    private final double rateOfInterest;
    private final int years;
    private int emiAmount;
    private Map<Integer, Integer> monthlyLedger;

    public Loan( int principalAmount, int amountToBeRepaid,int finalAmount, double rateOfInterest, int years, int emiAmount, Map<Integer, Integer> monthlyLedger) {
        this.principalAmount = principalAmount;
        this.amountToBeRepaid = amountToBeRepaid;
        this.finalAmount = finalAmount;
        this.rateOfInterest = rateOfInterest;
        this.years = years;
        this.emiAmount = emiAmount;
        this.monthlyLedger = monthlyLedger;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getPrincipalAmount() {
        return principalAmount;
    }


    public int getAmountToBeRepaid() {
        return amountToBeRepaid;
    }

    public void setAmountToBeRepaid(int amountToBeRepaid) {
        this.amountToBeRepaid = amountToBeRepaid;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }


    public int getYears() {
        return years;
    }


    public int getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(int emiAmount) {
        this.emiAmount = emiAmount;
    }

    public Map<Integer, Integer> getMonthlyLedger() {
        return monthlyLedger;
    }

    public void setMonthlyLedger(Map<Integer, Integer> monthlyLedger) {
        this.monthlyLedger = monthlyLedger;
    }

    public int getFinalAmount() {
        return finalAmount;
    }


}
