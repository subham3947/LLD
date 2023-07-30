package com.example.geektrust.entity;

public class Balance {

    private final String bankName;

    private final String userName;

    private final int amountRepaid;

    private final int emiLeft;

    public String getBankName() {
        return bankName;
    }



    public int getEmiLeft() {
        return emiLeft;
    }

    public String getUserName() {
        return userName;
    }


    public int getAmountRepaid() {
        return amountRepaid;
    }



    public Balance(String bankName, String userName, int amountRepaid, int emiLeft) {
        this.bankName = bankName;
        this.userName = userName;
        this.amountRepaid = amountRepaid;
        this.emiLeft = emiLeft;
    }







}
