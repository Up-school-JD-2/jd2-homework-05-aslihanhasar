package com.aslihanhsr.paymentSystem.exceptionManagement;

public class InvalidCardExpirationDateException extends Exception{
    private final String expirationDate;
    public InvalidCardExpirationDateException(String message, String expirationDate){
        super(message);
        this.expirationDate=expirationDate;
    }

    public String expirationDate() {
        return expirationDate;
    }
}
