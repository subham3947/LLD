package com.example.geektrust.service;

import com.example.geektrust.entity.Loan;

public interface EmiPayment {

    public void calculateAllPendingEmi(Loan loan, int emiNumber);
}
