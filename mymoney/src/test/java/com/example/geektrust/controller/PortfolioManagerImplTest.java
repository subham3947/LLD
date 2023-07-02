package com.example.geektrust.controller;

import com.example.geektrust.entity.Portfolio;
import com.example.geektrust.service.PortfolioManagingService;
import com.example.geektrust.service.PortfolioManagingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortfolioManagerImplTest {

    PortfolioManager portfolioManager;

    PortfolioManagingService portfolioManagingService;
    Portfolio portfolio;

    @Test
    void processOrderAllocate() {

        String order = "ALLOCATE 6000 3000 1000";
        portfolioManager.processOrder(order);
        assertEquals(portfolio.getEquity().getInitialInvestment(), 6000);
        assertEquals(portfolio.getDebt().getInitialInvestment(), 3000);
        assertEquals(portfolio.getGold().getInitialInvestment(), 1000);
    }

    @Test
    void processOrderSip() {
        String order = "SIP 2000 1000 500";
        processOrderAllocate();
        portfolioManager.processOrder(order);

    }

    @Test
    void processOrderChange() {
        //CHANGE 4.00% 10.00% 2.00% JANUARY
        processOrderSip();
        String order = "CHANGE 4.00% 10.00% 2.00% JANUARY";
        portfolioManager.processOrder(order);
    }

    @Test
    void processOrderBalance() {
        //BALANCE MARCH
        processOrderChange();
        String order = "BALANCE JANUARY";
        portfolioManager.processOrder(order);
    }

    @Test
    void processOrderRebalance() {
        //REBALANCE
        processOrderChange();
        String order = "REBALANCE";
        portfolioManager.processOrder(order);
    }

    @BeforeEach
    void setUp() {
        portfolioManager = new PortfolioManagerImpl();
        portfolioManagingService = new PortfolioManagingServiceImpl();
        portfolio = portfolioManagingService.initializePortfolio(6000, 3000, 1000);

    }
}