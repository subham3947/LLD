package com.example.geektrust.service;

import com.example.geektrust.entity.Loan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LumpSumPaymentImplTest {

    LumpSumPaymentImpl lumpSumPaymentImpl;
    Loan loan;
    LoanProcessorImpl loanProcessorImpl;


    @BeforeEach
    void setUp() {
        lumpSumPaymentImpl = new LumpSumPaymentImpl();
        loanProcessorImpl = new LoanProcessorImpl();
        //LOAN IDIDI Dale 5000 1 6
        loan = loanProcessorImpl.initializeLoan( "IDIDI",  5000,  1,  6);
    }

    @Test
    void processLumpSumPayment() {

        lumpSumPaymentImpl.processLumpSumPayment(loan, 5,1000);
        assertEquals(2090, loan.getAmountToBeRepaid());

    }
}