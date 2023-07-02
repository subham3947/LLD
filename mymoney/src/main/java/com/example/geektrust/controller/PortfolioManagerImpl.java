package com.example.geektrust.controller;

import com.example.geektrust.constants.Month;
import com.example.geektrust.constants.Operations;
import com.example.geektrust.entity.Balance;
import com.example.geektrust.entity.Portfolio;
import com.example.geektrust.exceptions.CannotRebalanceException;
import com.example.geektrust.service.PortfolioManagingService;
import com.example.geektrust.service.PortfolioManagingServiceImpl;

public class PortfolioManagerImpl implements PortfolioManager{

    public static final int ZERO = 0, TWO = 2, THREE = 3, FOUR = 4, ONE = 1, FIVE = 5;
    Portfolio portfolio;
    PortfolioManagingService portfolioManagingService;

    public PortfolioManagerImpl() {
        portfolioManagingService = new PortfolioManagingServiceImpl();
    }


    @Override
    public void processOrder(String orderString)  {

        String[] orderDetails = orderString.split(" ");
        String op = orderDetails[ZERO];
        switch(Operations.valueOf(op)) {

            case ALLOCATE:
                allocate(Integer.parseInt(orderDetails[ONE]), Integer.parseInt(orderDetails[TWO]),
                        Integer.parseInt(orderDetails[THREE]));
                break;
            case SIP:
                sip(Integer.parseInt(orderDetails[ONE]), Integer.parseInt(orderDetails[TWO]),
                        Integer.parseInt(orderDetails[THREE]));
                break;
            case CHANGE:
                String equityPercent = orderDetails[ONE],debtPercent = orderDetails[TWO], goldPercent = orderDetails[THREE];

                change(Double.parseDouble(equityPercent.substring(ZERO, equityPercent.length() - ONE)),
                        Double.parseDouble(debtPercent.substring(ZERO, debtPercent.length() - ONE)),
                        Double.parseDouble(goldPercent.substring(ZERO, goldPercent.length() - ONE)),
                        orderDetails[FOUR]);
                break;
            case BALANCE:
                printBalance(orderDetails[ONE]);
                break;
            case REBALANCE:
                getLastRebalancedAmount();
                break;
        }
    }
    private void allocate(int equityAmount, int debtAmount, int goldAmount){
        portfolio = portfolioManagingService.initializePortfolio(equityAmount,  debtAmount,  goldAmount);
    }
    private void sip(int equityAmount, int debtAmount, int goldAmount){
        portfolioManagingService.startSip(portfolio, equityAmount,  debtAmount,  goldAmount);
    }

    private void change(double percentageChangeInEquity, double percentageChangeInDebt, double percentageChangeInGold,
                        String month){
        int monthIndex = Month.monthMap.get(month);
        portfolioManagingService.performMonthlyChange( portfolio, monthIndex, percentageChangeInEquity, percentageChangeInDebt,
                percentageChangeInGold);
    }

    private void printBalance(String month){
        int monthIndex = Month.monthMap.get(month);
        Balance currentMonthBalance = portfolio.getMonthlyBalanceMap().get(monthIndex);
        System.out.println(currentMonthBalance.getEquityAmount()+" "+currentMonthBalance.getDebtAmount()
                            +" "+currentMonthBalance.getGoldAmount());
    }

    private void getLastRebalancedAmount()  {
        try {
            Balance balance = portfolioManagingService.retrieveLastRebalancedAmount(portfolio);
            System.out.println(balance.getEquityAmount()+" "+balance.getDebtAmount()
                    +" "+balance.getGoldAmount());
        } catch (CannotRebalanceException e) {
            System.out.println(e.getMessage());
        }
    }

}
