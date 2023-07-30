package com.example.geektrust.service;


import com.example.geektrust.entity.Balance;
import com.example.geektrust.entity.Loan;

import java.util.Map;


public class BalanceRetrieverImpl implements BalanceRetriever {


    EmiPayment emiPayment;

    public BalanceRetrieverImpl() {
        emiPayment = new EmiPaymentImpl();
    }
    @Override
    public Balance getBalance(int emiNumber, String userName, Loan loan) {
        Map<Integer, Integer> monthlyLedger = loan.getMonthlyLedger();
        int amountRepaid = 0;
        //if(emiNumber > 0){
            emiPayment.calculateAllPendingEmi(loan, emiNumber);
            amountRepaid = monthlyLedger.getOrDefault(emiNumber, 0);
        //}

        int amountToBePaid = loan.getFinalAmount() - amountRepaid;


        return new Balance(loan.getBankName(), userName, amountRepaid,
                (int)Math.ceil((double)amountToBePaid/ (double) loan.getEmiAmount()));
    }
}
