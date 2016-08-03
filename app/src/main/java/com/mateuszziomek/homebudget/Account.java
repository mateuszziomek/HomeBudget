package com.mateuszziomek.homebudget;

/**
 * Object of this class represents accounts available in the application.
 */
public class Account {
    private String mName;
    private double mBalance;

    public Account(String mName) {
        this.mName = mName;
    }

    public String getName() {
        return mName;
    }

    public double getBalance() {
        return mBalance;
    }

    public void setBalance(double mBalance) {
        this.mBalance = mBalance;
    }

    public void add(double value) {
        this.mBalance += value;
    }

    public void subtract(double value) {
        this.mBalance -= value;
    }
}
