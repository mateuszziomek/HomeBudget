package com.mateuszziomek.homebudget;

/**
 * Object of this class represents each item that will be added to the database.
 * It contains values input by the user.
 */
public class Item {
    private int _id = 0;
    private String positionType, category, date, what, account;
    private double amount;

    // Constructor to count IDs
    public Item() {
        _id++;
    }

    @Override
    public String toString() {
        return "ID: " + _id + " | TYPE: " + positionType + " | CATEGORY: " + category + " | DATE: " + date +
                " | WHAT: " + what + " | AMOUNT: " + amount + " | ACCOUNT: " + account;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
