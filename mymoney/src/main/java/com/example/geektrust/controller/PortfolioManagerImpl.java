package com.example.geektrust.controller;

import com.example.geektrust.constants.Month;
import com.example.geektrust.constants.Operations;
import com.example.geektrust.entity.Balance;
import com.example.geektrust.entity.Portfolio;
import com.example.geektrust.exceptions.CannotRebalanceException;
import com.example.geektrust.service.PortfolioManagingService;
import com.example.geektrust.service.PortfolioManagingServiceImpl;

public class PortfolioManagerImpl implements PortfolioManager{
    Portfolio portfolio;
    PortfolioManagingService portfolioManagingService;

    public PortfolioManagerImpl() {
        portfolioManagingService = new PortfolioManagingServiceImpl();
    }


    @Override
    public void processOrder(String orderString)  {

        String[] orderDetails = orderString.split(" ");
        String op = orderDetails[0];
        switch(Operations.valueOf(op)) {

            case ALLOCATE:
                allocate(Integer.parseInt(orderDetails[1]), Integer.parseInt(orderDetails[2]),
                        Integer.parseInt(orderDetails[3]));
                break;
            case SIP:
                sip(Integer.parseInt(orderDetails[1]), Integer.parseInt(orderDetails[2]),
                        Integer.parseInt(orderDetails[3]));
                break;
            case CHANGE:
                String equityPercent = orderDetails[1],debtPercent = orderDetails[2], goldPercent = orderDetails[3];

                change(Double.parseDouble(equityPercent.substring(0, equityPercent.length() - 1)),
                        Double.parseDouble(debtPercent.substring(0, debtPercent.length() - 1)),
                        Double.parseDouble(goldPercent.substring(0, goldPercent.length() - 1)),
                        orderDetails[4]);
                break;
            case BALANCE:
                printBalance(orderDetails[1]);
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
