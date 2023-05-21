package com.aslihanhsr.paymentSystem.customExceptions;

public class SystemNotWorkingException extends RuntimeException {
    public SystemNotWorkingException(String message) {
        super(message);
    }
}
