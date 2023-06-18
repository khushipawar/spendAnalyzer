package com.optum.statistics.model;

public class StatisticsDTO {

    private String account;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private  String password;
    private double balance;
    private double totalIncome;
    private double totalExpenses;

    public StatisticsDTO(String account,String password, double totalIncome, double totalExpenses, double balance) {
        this.account=account;
        this.password = password;
        this.balance=balance;
        this.totalExpenses=totalExpenses;
        this.totalIncome=totalIncome;
    }

    public StatisticsDTO() {

    }

    public static StatisticsDTO fromStatistics(Statistics statistics) {
        StatisticsDTO statisticsDTO = new StatisticsDTO();
        statisticsDTO.setAccount(statistics.getAccount());
        statisticsDTO.setPassword(statistics.getPassword());
        statisticsDTO.setBalance(statistics.getBalance());
        statisticsDTO.setTotalIncome(statistics.getTotalIncome());
        statisticsDTO.setTotalExpenses(statistics.getTotalExpenses());
        return statisticsDTO;
    }


    // Getters and setters

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
