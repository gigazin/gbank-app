package com.github.gigazin.gbankapp.gbank;

public class CurrentAccount extends Client {
    private String accountNumber;
    private double balance;
    private Client client;
    private Agency agency;

    public CurrentAccount() {
    }

    public CurrentAccount(String accountNumber, double balance, Client client, Agency agency) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.client = client;
        this.agency = agency;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

}
