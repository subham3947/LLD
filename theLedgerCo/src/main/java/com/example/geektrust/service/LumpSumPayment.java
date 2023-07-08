package com.example.geektrust.service;

import com.example.geektrust.entity.Loan;

public interface LumpSumPayment {

    public void processLumpSumPayment(Loan loan, int emiNumber, int lumpSumAmount);
}
