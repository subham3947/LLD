package com.example.geektrust.service;

import com.example.geektrust.entity.Loan;

public interface LoanProcessor {

    public Loan initializeLoan(String bankName, int amount, int years, double rateOfInterest);
}
