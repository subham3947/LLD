package com.example.geektrust.service;

import com.example.geektrust.entity.Loan;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LoanProcessorImpl implements  LoanProcessor{

    public static final int NUMBER_OF_MONTHS = 12;
    public static final int HUNDRED = 100;
    @Override
    public Loan initializeLoan(String bankName, int amount, int years, double rateOfInterest) {
        Loan loan =  buildLoanObject(amount, years, rateOfInterest);
        loan.setBankName(bankName);
        return loan;
    }

    private Loan buildLoanObject( int amount, int years, double rateOfInterest){

        int amountToBeRepaid = amount + calculateInterest(amount, years, rateOfInterest);
        int emiAmount = calculateEmiAmount(amountToBeRepaid, years);
        Map<Integer, Integer> monthlyLedger = getMonthlyLedger(years);
        return new Loan( amount, amountToBeRepaid,amountToBeRepaid, rateOfInterest, years, emiAmount, monthlyLedger);
    }

    private TreeMap<Integer, Integer> getMonthlyLedger(int years) {

        return IntStream.rangeClosed(0, years * NUMBER_OF_MONTHS)
                .boxed()
                .collect(Collectors.toMap(key -> key, value -> 0, (v1, v2) -> v2, TreeMap::new));
    }

    private int calculateEmiAmount(int amountToBeRepaid, int years) {
        return (int)(Math.ceil(((double)amountToBeRepaid/(double)(years * NUMBER_OF_MONTHS) )));
    }

    private int calculateInterest(int amount, int years, double rateOfInterest) {
        return (int)(Math.ceil((amount * years * rateOfInterest)/HUNDRED));
    }
}
