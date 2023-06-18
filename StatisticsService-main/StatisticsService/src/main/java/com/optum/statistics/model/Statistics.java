package com.optum.statistics.model;

public class Statistics {

    private String account;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
    private double balance;
    private double totalIncome;
    private double totalExpenses;

    // Constructors, getters, and setters

    public Statistics(String account,String password, double balance, double totalIncome, double totalExpenses) {
        this.account = account;
        this.password = password;
        this.balance = balance;
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }
}
