package com.example.geektrust.service;

import com.example.geektrust.entity.Balance;
import com.example.geektrust.entity.Loan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalanceRetrieverImplTest {

    BalanceRetrieverImpl balanceRetrieverImpl;
    LoanProcessorImpl loanProcessorImpl;


    @BeforeEach
    void setUp() {
        balanceRetrieverImpl = new BalanceRetrieverImpl();
        loanProcessorImpl = new LoanProcessorImpl();
    }

    @Test
    void getBalance() {
        //BALANCE IDIDI Dale 5
        Loan loan = loanProcessorImpl.initializeLoan("IDIDI",10000,5,4);
        Balance balance = balanceRetrieverImpl.getBalance(5,"Dale", loan);
        assertEquals(1000, balance.getAmountRepaid());
        assertEquals(55, balance.getEmiLeft());
        assertEquals("Dale", balance.getUserName());
    }
}