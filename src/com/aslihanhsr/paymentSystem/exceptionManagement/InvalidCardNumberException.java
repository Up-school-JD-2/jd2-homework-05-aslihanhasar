package com.aslihanhsr.paymentSystem.exceptionManagement;

public class InvalidCardNumberException extends Exception{
    private final String cardNumber;
    public InvalidCardNumberException(String message,String cardNumber){
        super(message);
        this.cardNumber= cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
