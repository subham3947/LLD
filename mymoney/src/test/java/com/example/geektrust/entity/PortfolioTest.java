package com.example.geektrust.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortfolioTest {

    Portfolio portfolio;
    @Test
    void getEquity() {
        assertEquals(new Asset(6000, 60), portfolio.getEquity());
    }

    @Test
    void getGold() {
        assertEquals(new Asset(1000, 10), portfolio.getGold());
    }

    @Test
    void getDebt() {
        assertEquals(new Asset(3000, 30), portfolio.getDebt());
    }


    @Test
    void testSetEquity() {
        portfolio.setEquity(new Asset(9000, 90));
        assertEquals(9000, portfolio.getEquity().getInitialInvestment());
        assertEquals(90, portfolio.getEquity().getInitialWeightage());
    }

    @Test
    void testSetGold() {
        portfolio.setGold(new Asset(8000, 80));
        assertEquals(8000, portfolio.getGold().getInitialInvestment());
        assertEquals(80, portfolio.getGold().getInitialWeightage());
    }

    @Test
    void testSetDebt() {
        portfolio.setDebt(new Asset(7000, 70));
        assertEquals(7000, portfolio.getDebt().getInitialInvestment());
        assertEquals(70, portfolio.getDebt().getInitialWeightage());
    }

    @BeforeEach
    void setUp() {
        Asset equity = new Asset(6000, 60);
        Asset debt = new Asset(3000, 30);
        Asset gold = new Asset(1000, 10);

        portfolio = new Portfolio(equity, debt, gold);

    }


}