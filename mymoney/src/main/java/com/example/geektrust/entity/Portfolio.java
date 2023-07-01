package com.example.geektrust.entity;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {

    public static final int NUMBER_OF_MONTHS_IN_A_YEAR = 12;

    Asset equity;
    Asset gold;
    Asset debt;

    public Map<Integer, Balance> getMonthlyBalanceMap() {
        return monthlyBalanceMap;
    }

    public void setMonthlyBalanceMap(Map<Integer, Balance> monthlyBalanceMap) {
        this.monthlyBalanceMap = monthlyBalanceMap;
    }

    Map<Integer, Balance> monthlyBalanceMap;
    public Portfolio(Asset equity, Asset debt, Asset gold ) {
        this.equity = equity;
        this.gold = gold;
        this.debt = debt;

        monthlyBalanceMap = new HashMap<>();
        monthlyBalanceMap.put(1, new Balance(equity.getInitialInvestment(), debt.getInitialInvestment(),
                                gold.getInitialInvestment()));
    }

    public Asset getEquity() {
        return equity;
    }

    public void setEquity(Asset equity) {
        this.equity = equity;
    }

    public Asset getGold() {
        return gold;
    }

    public void setGold(Asset gold) {
        this.gold = gold;
    }

    public Asset getDebt() {
        return debt;
    }

    public void setDebt(Asset debt) {
        this.debt = debt;
    }

}
