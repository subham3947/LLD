package com.example.geektrust.entity;

import com.example.geektrust.service.LoanProcessorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest {

    Loan loan;
    LoanProcessorImpl loanProcessorImpl;
    @BeforeEach
    void  setup(){
        //LOAN UON Shelly 15000 2 9
        loanProcessorImpl = new LoanProcessorImpl();
        loan = loanProcessorImpl.initializeLoan("UON",15000, 2, 9);
    }
    @Test
    void getBankName() {
        assertEquals("UON", loan.getBankName());
    }

    @Test
    void getPrincipalAmount() {
        assertEquals(15000, loan.getPrincipalAmount());
    }

    @Test
    void getAmountToBeRepaid() {
        assertEquals(17700, loan.getAmountToBeRepaid());
    }

    @Test
    void getRateOfInterest() {
        assertEquals(9, loan.getRateOfInterest());
    }

    @Test
    void getYears() {
        assertEquals(2, loan.getYears());
    }

    @Test
    void getEmiAmount() {
        assertEquals(738, loan.getEmiAmount());
    }

}