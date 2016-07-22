package com.mateuszziomek.homebudget;

/**
 * Object of this class represent all accounts available in the application.
 */
public class Account {
    private double total, savings, account_matys, account_lu, wallet_matys, wallet_lu, envelope;

    public double getTotal() {

        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public double getAccount_matys() {
        return account_matys;
    }

    public void setAccount_matys(double account_matys) {
        this.account_matys = account_matys;
    }

    public double getAccount_lu() {
        return account_lu;
    }

    public void setAccount_lu(double account_lu) {
        this.account_lu = account_lu;
    }

    public double getWallet_matys() {
        return wallet_matys;
    }

    public void setWallet_matys(double wallet_matys) {
        this.wallet_matys = wallet_matys;
    }

    public double getWallet_lu() {
        return wallet_lu;
    }

    public void setWallet_lu(double wallet_lu) {
        this.wallet_lu = wallet_lu;
    }

    public double getEnvelope() {
        return envelope;
    }

    public void setEnvelope(double envelope) {
        this.envelope = envelope;
    }

    public void addAmount(String account, double amount) {
        switch (account) {
            case "Oszczędności":
                this.savings = this.savings + amount;
                break;

            case "Konto Matys":
                this.account_matys = this.account_matys + amount;
                break;

            case "Portfel Matys":
                this.wallet_matys = this.wallet_matys + amount;
                break;

            case "Konto Lu":
                this.account_lu = this.account_lu + amount;
                break;

            case "Portfel Lu":
                this.wallet_lu = this.wallet_lu + amount;
                break;

            case "Koperta":
                this.envelope = this.envelope + amount;
                break;
        }
    }

    public void substractAmount(String account, double amount) {
        switch (account) {
            case "Oszczędności":
                this.savings = this.savings - amount;
                break;

            case "Konto Matys":
                this.account_matys = this.account_matys - amount;
                break;

            case "Portfel Matys":
                this.wallet_matys = this.wallet_matys - amount;
                break;

            case "Konto Lu":
                this.account_lu = this.account_lu - amount;
                break;

            case "Portfel Lu":
                this.wallet_lu = this.wallet_lu - amount;
                break;

            case "Koperta":
                this.envelope = this.envelope - amount;
                break;
        }
    }

}
