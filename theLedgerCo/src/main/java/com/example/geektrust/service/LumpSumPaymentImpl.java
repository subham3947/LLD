package com.example.geektrust.service;

import com.example.geektrust.entity.Loan;

import java.util.Map;

public class LumpSumPaymentImpl implements LumpSumPayment{

    EmiPayment emiPayment;

    public LumpSumPaymentImpl() {
        emiPayment = new EmiPaymentImpl();
    }

    @Override
    public void processLumpSumPayment(Loan loan, int emiNumber, int lumpSumAmount) {

        emiPayment.calculateAllPendingEmi(loan, emiNumber);
        adjustLumpSumAmount(loan, emiNumber, lumpSumAmount);

    }

    private void adjustLumpSumAmount(Loan loan, int emiNumber, int lumpSumAmount) {

        Map<Integer, Integer> monthlyLedger = loan.getMonthlyLedger();
        monthlyLedger.put(emiNumber, monthlyLedger.getOrDefault(emiNumber, 0) + lumpSumAmount);
        loan.setAmountToBeRepaid(loan.getAmountToBeRepaid() - lumpSumAmount);
        if(loan.getAmountToBeRepaid() < loan.getEmiAmount())
                loan.setEmiAmount(loan.getAmountToBeRepaid());
    }


}
