package com.onelab.demo.model;

 
public class Settlement {

    public String id;
    public String transactionId;
    public double amount;
    public String date;

    public Settlement(String id, String transactionId, double amount, String date) {
        this.id = id;
        this.transactionId = transactionId;
        this.amount = amount;
        this.date = date;
    }
}