package com.example.geektrust.service;

import com.example.geektrust.entity.Loan;

import java.util.Map;

public class EmiPaymentImpl implements EmiPayment{

    public void calculateAllPendingEmi(Loan loan, int emiNumber) {

        Map<Integer, Integer> monthlyLedger = loan.getMonthlyLedger();
        int pendingEmiStartingNumber  = 0;
        for(Map.Entry<Integer, Integer> entry : monthlyLedger.entrySet()) {
            if(entry.getValue() == 0 && entry.getKey() != 0){
                pendingEmiStartingNumber = entry.getKey();
                break;
            }
        }
        int previousPaidAmount = (pendingEmiStartingNumber != 0) ? monthlyLedger.get(pendingEmiStartingNumber - 1) : 0;
        populateAllPendingEmi(monthlyLedger, previousPaidAmount, pendingEmiStartingNumber, emiNumber, loan);
        loan.setMonthlyLedger(monthlyLedger);
    }

    private void populateAllPendingEmi(Map<Integer, Integer> monthlyLedger, int previousPaidAmount,
                                       int pendingEmiStartingNumber, int emiNumber, Loan loan) {
        int amountToBeRepaid = loan.getAmountToBeRepaid();
        for(int i = pendingEmiStartingNumber; i <= emiNumber; i++) {
            monthlyLedger.put(i, Math.min(previousPaidAmount + loan.getEmiAmount(), loan.getFinalAmount()));
            previousPaidAmount += loan.getEmiAmount();
            amountToBeRepaid -= loan.getEmiAmount();
        }
        loan.setAmountToBeRepaid(amountToBeRepaid);
    }
}
