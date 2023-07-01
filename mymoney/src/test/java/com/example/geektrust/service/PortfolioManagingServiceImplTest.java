package com.example.geektrust.service;

import com.example.geektrust.entity.Portfolio;
import com.example.geektrust.entity.Balance;
import com.example.geektrust.exceptions.CannotRebalanceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortfolioManagingServiceImplTest {

    Portfolio portfolio;
    PortfolioManagingService portfolioManagingService;
    @Test
    void initializePortfolio() {

        assertEquals(6000, portfolio.getEquity().getInitialInvestment());
        assertEquals(3000, portfolio.getDebt().getInitialInvestment());
        assertEquals(1000, portfolio.getGold().getInitialInvestment());

        assertEquals(60,portfolio.getEquity().getInitialWeightage());
        assertEquals(30,portfolio.getDebt().getInitialWeightage());
        assertEquals(10,portfolio.getGold().getInitialWeightage());

    }

    @Test
    void startSip() {
        assertEquals(2000, portfolio.getEquity().getSipAmount());
        assertEquals(1000, portfolio.getDebt().getSipAmount());
        assertEquals(500, portfolio.getGold().getSipAmount());


    }

    @Test
    void performMonthlyChangeJanuary() {
        //3300	6240	1020
        portfolioManagingService.performMonthlyChange(portfolio,1, 4.0, 10.0, 2.0 );
        assertEquals(6240,portfolio.getMonthlyBalanceMap().get(1).getEquityAmount());
        assertEquals(3300,portfolio.getMonthlyBalanceMap().get(1).getDebtAmount());
        assertEquals(1020,portfolio.getMonthlyBalanceMap().get(1).getGoldAmount());
    }

    @Test
    void performMonthlyChangeFebruary() {
        //6020	7416	1520	FEBRUARY
        performMonthlyChangeJanuary();
        portfolioManagingService.performMonthlyChange(portfolio,2, -10.0,
                            40.0, 0.0 );
        assertEquals(7416,portfolio.getMonthlyBalanceMap().get(2).getEquityAmount());
        assertEquals(6020,portfolio.getMonthlyBalanceMap().get(2).getDebtAmount());
        assertEquals(1520,portfolio.getMonthlyBalanceMap().get(2).getGoldAmount());
    }

    @Test
    void performMonthlyChangeMarch() {
        //7897	10593	2272	MARCH
        performMonthlyChangeFebruary();
        portfolioManagingService.performMonthlyChange(portfolio,3, 12.50,
                12.50, 12.50 );
        assertEquals(10593,portfolio.getMonthlyBalanceMap().get(3).getEquityAmount());
        assertEquals(7897,portfolio.getMonthlyBalanceMap().get(3).getDebtAmount());
        assertEquals(2272,portfolio.getMonthlyBalanceMap().get(3).getGoldAmount());
    }

    @Test
    void performMonthlyChangeApril() {
        //13600  8630		2966	APRIL
        performMonthlyChangeMarch();
        portfolioManagingService.performMonthlyChange(portfolio,4, 8,-3.0,
                7.0 );
        assertEquals(13600,portfolio.getMonthlyBalanceMap().get(4).getEquityAmount());
        assertEquals(8630,portfolio.getMonthlyBalanceMap().get(4).getDebtAmount());
        assertEquals(2966,portfolio.getMonthlyBalanceMap().get(4).getGoldAmount());

    }

    @Test
    void performMonthlyChangeMay() {
        // 17628 11652		3829	MAY
        performMonthlyChangeApril();
        portfolioManagingService.performMonthlyChange(portfolio,5, 13.0,
                21.0, 10.50 );
        assertEquals(17628,portfolio.getMonthlyBalanceMap().get(5).getEquityAmount());
        assertEquals(11652,portfolio.getMonthlyBalanceMap().get(5).getDebtAmount());
        assertEquals(3829,portfolio.getMonthlyBalanceMap().get(5).getGoldAmount());
    }

    @Test
    void performMonthlyChangeJune() {
        // 11809	23619	3936 JUNE
        performMonthlyChangeMay();
        portfolioManagingService.performMonthlyChange(portfolio,6, 10.0,
                8.0, -5.0 );
        assertEquals(23619,portfolio.getMonthlyBalanceMap().get(6).getEquityAmount());
        assertEquals(11809,portfolio.getMonthlyBalanceMap().get(6).getDebtAmount());
        assertEquals(3936,portfolio.getMonthlyBalanceMap().get(6).getGoldAmount());

    }

    @Test
    void retrieveMonthlyBalance() {
        //10593 7897 2272
        performMonthlyChangeJune();
        Balance marchBalance = portfolioManagingService.retrieveMonthlyBalance(portfolio, 3);
        assertEquals(10593, marchBalance.getEquityAmount());
        assertEquals(7897, marchBalance.getDebtAmount());
        assertEquals(2272, marchBalance.getGoldAmount());

    }

//    @Test
//    void retrieveLastRebalancedAmount() {
//        // 23619 11809 3936
//        //performMonthlyChangeJune();
//        try {
//            Balance balance = portfolioManagingService.retrieveLastRebalancedAmount(portfolio);
//            assertEquals(23619 , balance.getEquityAmount());
//            assertEquals(11809 , balance.getDebtAmount());
//            assertEquals(3936 , balance.getGoldAmount());
//        } catch (CannotRebalanceException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Test
    void retrieveLastRebalancedAmountException() {

        try {
            Balance balance = portfolioManagingService.retrieveLastRebalancedAmount(portfolio);
            Exception exception = assertThrows(RuntimeException.class,
                    ()->{portfolioManagingService.retrieveLastRebalancedAmount(portfolio);});


            String expectedMessage = "CANNOT_REBALANCE";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));

        } catch (CannotRebalanceException e) {

        }
    }

    @BeforeEach
    void setUp() {
        portfolioManagingService = new PortfolioManagingServiceImpl();
        portfolio = portfolioManagingService.initializePortfolio(6000, 3000, 1000);
        portfolioManagingService.startSip(portfolio, 2000, 1000, 500);

    }
}