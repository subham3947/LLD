package com.example.geektrust.service;

import com.example.geektrust.entity.Balance;
import com.example.geektrust.entity.Loan;

public interface BalanceRetriever {

    public Balance getBalance(int month, String userName, Loan loan);
}
