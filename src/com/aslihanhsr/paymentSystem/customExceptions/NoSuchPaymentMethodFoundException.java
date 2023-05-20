package com.aslihanhsr.paymentSystem.customExceptions;

public class NoSuchPaymentMethodFoundException extends Exception {

    public NoSuchPaymentMethodFoundException(String message){
        super(message);
    }
}
