package com.aslihanhsr.paymentSystem.exceptionManagement;

public class InvalidAmountException extends Exception{
    private final String amount;
    public InvalidAmountException(String message,String amount){
        super(message);
        this.amount=amount;
    }

    public String getAmount() {
        return amount;
    }
}
