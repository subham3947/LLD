package com.example.geektrust.controller;

import com.example.geektrust.constants.Transactions;
import com.example.geektrust.dao.LoanDaoImpl;
import com.example.geektrust.entity.Balance;
import com.example.geektrust.entity.Loan;
import com.example.geektrust.service.*;

public class LoanAgentImpl implements  LoanAgent{

    LoanProcessor loanProcessor;
    LumpSumPayment lumpSumPayment;
    BalanceRetriever balanceRetriever;
    Loan loan;
    LoanDaoImpl loanDaoImpl;
    public LoanAgentImpl() {
        loanProcessor = new LoanProcessorImpl();
        lumpSumPayment = new LumpSumPaymentImpl();
        balanceRetriever = new BalanceRetrieverImpl();
        loanDaoImpl = LoanDaoImpl.getInstance();
    }

    @Override
    public void performTransaction(String transactionString) {

        String[] transactionArray = transactionString.split(" ");
        String transaction =  transactionArray[0];

        switch(Transactions.valueOf(transaction)) {

            case LOAN:
                loan = loanProcessor.initializeLoan(transactionArray[1], Integer.parseInt(transactionArray[3]),
                        Integer.parseInt(transactionArray[4]),Integer.parseInt(transactionArray[5]));

                loanDaoImpl.updateLoanDetails(transactionArray[2],transactionArray[1],loan);
                break;
            case PAYMENT:
                loan = loanDaoImpl.getLoanDetails(transactionArray[2], transactionArray[1]);
                lumpSumPayment.processLumpSumPayment(loan, Integer.parseInt(transactionArray[4]),
                        Integer.parseInt(transactionArray[3]));
                loanDaoImpl.updateLoanDetails(transactionArray[1],transactionArray[2],loan);
                break;

            case BALANCE:
                loan = loanDaoImpl.getLoanDetails(transactionArray[2], transactionArray[1]);
                Balance balance = balanceRetriever.getBalance(Integer.parseInt(transactionArray[3]),
                        transactionArray[2], loan);
                System.out.println(balance.getBankName()+" "+balance.getUserName()+" "+balance.getAmountRepaid()
                        +" "+balance.getEmiLeft());
                break;

        }

    }
}
