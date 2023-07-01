package com.example.geektrust.service;

import com.example.geektrust.entity.*;
import com.example.geektrust.exceptions.CannotRebalanceException;

import java.util.Map;

public class PortfolioManagingServiceImpl implements  PortfolioManagingService{

    public static final int JANUARY = 1, JUNE = 6, DECEMBER = 12;
    @Override
    public Portfolio initializePortfolio(int equityAmount, int debtAmount, int goldAmount) {
        int totalAmount = equityAmount + debtAmount + goldAmount;
        Asset equity = new Asset(equityAmount, getWeightage(equityAmount, totalAmount));
        Asset debt = new Asset(debtAmount, getWeightage(debtAmount, totalAmount));
        Asset gold = new Asset(goldAmount, getWeightage(goldAmount, totalAmount));
        return new Portfolio(equity, debt, gold);
    }

    private int getWeightage(int investmentAmount, int totalAmount) {
        return (investmentAmount  * 100) / totalAmount;
    }

    @Override
    public void startSip(Portfolio portfolio,int equitySipAmount, int debtSipAmount, int goldSipAmount) {
        portfolio.getEquity().setSipAmount(equitySipAmount);
        portfolio.getDebt().setSipAmount(debtSipAmount);
        portfolio.getGold().setSipAmount(goldSipAmount);
    }

    @Override
    public void performMonthlyChange(Portfolio portfolio, int month, double equityChangePercentage,
                                     double debtChangePercentage, double goldChangePercentage) {
        Map<Integer, Balance> balanceMap = portfolio.getMonthlyBalanceMap();
        if(month != JANUARY){
            addSipToEachAsset(portfolio, month);
        }
        Balance currentMonthBalance = balanceMap.get(month);
        currentMonthBalance.setEquityAmount(adjustAssetAmountByChangePercentage(currentMonthBalance.getEquityAmount(),
                                            equityChangePercentage));
        currentMonthBalance.setDebtAmount(adjustAssetAmountByChangePercentage(currentMonthBalance.getDebtAmount(),
                                            debtChangePercentage));
        currentMonthBalance.setGoldAmount(adjustAssetAmountByChangePercentage(currentMonthBalance.getGoldAmount(),
                                            goldChangePercentage));
        if(month == JUNE || month == DECEMBER)
                rebalance(portfolio, currentMonthBalance);
        balanceMap.put(month, currentMonthBalance);
        portfolio.setMonthlyBalanceMap(balanceMap);
    }

    private int adjustAssetAmountByChangePercentage(int assetAmount, double changePercentage) {
        return (int) (Math.floor(assetAmount + ( changePercentage * assetAmount)/ 100) );
    }

    private int getAmountByWeightage(int assetAmount, double weightage) {
        return (int) (Math.floor( ( weightage * assetAmount)/ 100) );
    }

    private void rebalance(Portfolio portfolio, Balance currentMonthBalance) {
        int totalBalance = currentMonthBalance.getDebtAmount() + currentMonthBalance.getGoldAmount() + currentMonthBalance.getEquityAmount();
        currentMonthBalance.setEquityAmount(getAmountByWeightage(totalBalance, portfolio.getEquity().getInitialWeightage()));
        currentMonthBalance.setDebtAmount(getAmountByWeightage(totalBalance, portfolio.getDebt().getInitialWeightage()));
        currentMonthBalance.setGoldAmount(getAmountByWeightage(totalBalance, portfolio.getGold().getInitialWeightage()));
    }

    private void addSipToEachAsset(Portfolio portfolio, int month) {
        Map<Integer, Balance> balanceMap = portfolio.getMonthlyBalanceMap();
        Balance previousMonth = balanceMap.get(month - 1);
        Balance currentMonth = new Balance (previousMonth.getEquityAmount() + portfolio.getEquity().getSipAmount(),
                previousMonth.getDebtAmount() + portfolio.getDebt().getSipAmount(),
                previousMonth.getGoldAmount() + portfolio.getGold().getSipAmount());
        balanceMap.put(month, currentMonth);
        portfolio.setMonthlyBalanceMap(balanceMap);
    }

    @Override
    public Balance retrieveMonthlyBalance(Portfolio portfolio, int month) {
        return portfolio.getMonthlyBalanceMap().get(month);
    }


    @Override
    public Balance retrieveLastRebalancedAmount(Portfolio portfolio) throws CannotRebalanceException {
        if(portfolio.getMonthlyBalanceMap().size() == DECEMBER)
            return portfolio.getMonthlyBalanceMap().get(DECEMBER);
        else if (portfolio.getMonthlyBalanceMap().size() >= JUNE && portfolio.getMonthlyBalanceMap().size() < DECEMBER)
            return portfolio.getMonthlyBalanceMap().get(JUNE);
        else
            throw new CannotRebalanceException();
    }
}
