package com.aslihanhsr.paymentSystem.exceptionManagement;

public class InvalidAmountException extends Exception{
    private final double amount;
    public InvalidAmountException(String message,double amount){
        super(message);
        this.amount=amount;
    }

    public double getAmount() {
        return amount;
    }
}
