package com.aslihanhsr.paymentSystem.exceptionManagement;

public class NoSuchPaymentMethodFoundException extends Exception {

    public NoSuchPaymentMethodFoundException(String message){
        super(message);
    }
}
