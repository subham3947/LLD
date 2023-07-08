package com.example.geektrust.controller;

import com.example.geektrust.dao.LoanDaoImpl;
import com.example.geektrust.entity.Loan;
import com.example.geektrust.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


class LoanAgentImplTest {

    @InjectMocks
    LoanAgentImpl loanAgentImpl;

    LoanDaoImpl loanDao;

    @BeforeEach
    void setup(){
        loanAgentImpl = new LoanAgentImpl();
        loanDao = LoanDaoImpl.getInstance();
    }
    @Test
    void performLoanProcessingTransaction() {
        loanAgentImpl.performTransaction("LOAN UON Shelly 15000 2 9");
        Loan loan = loanDao.getLoanDetails("Shelly","UON");
        assertEquals(15000, loan.getPrincipalAmount());
        assertEquals(2, loan.getYears());
        assertEquals(9, loan.getRateOfInterest());
        assertEquals(17700, loan.getAmountToBeRepaid());
        assertEquals(738, loan.getEmiAmount());
    }
}