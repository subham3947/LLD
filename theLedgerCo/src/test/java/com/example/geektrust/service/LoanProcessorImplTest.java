package com.example.geektrust.service;

import com.example.geektrust.entity.Loan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanProcessorImplTest {

    LoanProcessorImpl loanProcessorImpl;
    @BeforeEach
    void setUp() {
        loanProcessorImpl = new LoanProcessorImpl();
    }

    @Test
    void initializeLoan() {

        //LOAN IDIDI Dale 10000 5 4
        Loan loan = loanProcessorImpl.initializeLoan("IDIDI", 10000, 5, 4);
        assertEquals(4, loan.getRateOfInterest());
        assertEquals(12000, loan.getAmountToBeRepaid());
        assertEquals(200, loan.getEmiAmount());
        assertEquals(10000, loan.getPrincipalAmount());
        assertEquals(5, loan.getYears());
        assertEquals("IDIDI", loan.getBankName());
        //LOAN UON Shelly 15000 2 9
        loan = loanProcessorImpl.initializeLoan("UON", 15000, 2, 9);
        assertEquals(9, loan.getRateOfInterest());
        assertEquals(17700, loan.getAmountToBeRepaid());
        assertEquals(738, loan.getEmiAmount());
        assertEquals(15000, loan.getPrincipalAmount());
        assertEquals(2, loan.getYears());
        assertEquals("UON", loan.getBankName());

    }
}