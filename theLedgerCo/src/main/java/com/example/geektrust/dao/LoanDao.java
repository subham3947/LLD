package com.example.geektrust.dao;

import com.example.geektrust.entity.Loan;

public interface LoanDao {

    public Loan getLoanDetails(String userName, String bankName);

    public void updateLoanDetails(String userName, String bankName, Loan loan);
}
