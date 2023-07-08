package com.example.geektrust.dao;

import com.example.geektrust.entity.Loan;

import java.util.HashMap;
import java.util.Map;

public class LoanDaoImpl implements  LoanDao{

    static LoanDaoImpl loanDao;
    private static final String USER_BANK_DELIMITER = "-";
    private static Map<String, Loan> loanMap;

    private LoanDaoImpl(){}

    public static LoanDaoImpl getInstance() {
        if(loanDao == null){
            loanDao = new LoanDaoImpl();
            loanMap = new HashMap<>();
        }
        return loanDao;
    }

    @Override
    public Loan getLoanDetails(String userName, String bankName) {

        return loanMap.get(userName+USER_BANK_DELIMITER+bankName);
    }

    @Override
    public void updateLoanDetails(String userName, String bankName, Loan loan) {
        loanMap.put(userName+USER_BANK_DELIMITER+bankName, loan);
    }
}
