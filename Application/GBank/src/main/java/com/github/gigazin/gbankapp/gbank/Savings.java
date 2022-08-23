package com.github.gigazin.gbankapp.gbank;

public class Savings {
    private double balance;

    public Savings() {
    }

    public Savings(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }
}
