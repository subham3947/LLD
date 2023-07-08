package com.example.geektrust.dao;

import com.example.geektrust.entity.Loan;
import com.example.geektrust.service.LoanProcessorImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanDaoImplTest {

    LoanDaoImpl loanDaoImpl;
    Loan loan;

    LoanProcessorImpl loanProcessorImpl;


    @BeforeEach
    void setup(){
        loanDaoImpl = LoanDaoImpl.getInstance();
        loanProcessorImpl = new LoanProcessorImpl();
        loan = loanProcessorImpl.initializeLoan("UON", 15000,2,9);
    }
    @Test
    void getLoanDetails() {
        loanDaoImpl.updateLoanDetails("Shelly", "UON", loan);
        Loan loan = loanDaoImpl.getLoanDetails("Shelly", "UON");
        assertEquals(15000, loan.getPrincipalAmount());
        assertEquals(2, loan.getYears());
        assertEquals(9, loan.getRateOfInterest());
        assertEquals(17700, loan.getAmountToBeRepaid());
        assertEquals(738, loan.getEmiAmount());

    }

    @Test
    void updateLoanDetails() {
        loanDaoImpl.updateLoanDetails("Shelly", "UON", loan);
        Loan loan = loanDaoImpl.getLoanDetails("Shelly", "UON");
        assertEquals(15000, loan.getPrincipalAmount());
        assertEquals(2, loan.getYears());
        assertEquals(9, loan.getRateOfInterest());
        assertEquals(17700, loan.getAmountToBeRepaid());
        assertEquals(738, loan.getEmiAmount());

    }
}