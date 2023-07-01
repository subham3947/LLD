package com.example.geektrust.service;

import com.example.geektrust.entity.Balance;
import com.example.geektrust.entity.Portfolio;
import com.example.geektrust.exceptions.CannotRebalanceException;

public interface PortfolioManagingService {

    public Portfolio initializePortfolio(int equityAmount, int debtAmount, int goldAmount);

    public void startSip(Portfolio portfolio, int equityAmount, int debtAmount, int goldAmount);

    void performMonthlyChange(Portfolio portfolio, int month, double equityChangePercentage,
                              double debtChangePercentage, double goldChangePercentage);

    public Balance retrieveMonthlyBalance(Portfolio portfolio, int month);


    public Balance retrieveLastRebalancedAmount(Portfolio portfolio) throws CannotRebalanceException;

}
