package com.example.geektrust.entity;

public class Balance {

    private  String bankName;

    private String userName;

    private int amountRepaid;

    public Balance(String bankName, String userName, int amountRepaid, int emiLeft) {
        this.bankName = bankName;
        this.userName = userName;
        this.amountRepaid = amountRepaid;
        this.emiLeft = emiLeft;
    }

    private int emiLeft;



    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getEmiLeft() {
        return emiLeft;
    }

    public void setEmiLeft(int emiLeft) {
        this.emiLeft = emiLeft;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAmountRepaid() {
        return amountRepaid;
    }

    public void setAmountRepaid(int amountRepaid) {
        this.amountRepaid = amountRepaid;
    }






}
