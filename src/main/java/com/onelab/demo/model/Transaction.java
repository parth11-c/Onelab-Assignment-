package com.onelab.demo.model;

public class Transaction {

    public String id;
    public double amount;
    public String date;

    public Transaction(String id, double amount, String date) {
        this.id = id;
        this.amount = amount;
        this.date = date;
    }
}