package com.aslihanhsr.paymentSystem;

import com.aslihanhsr.paymentSystem.customExceptions.SystemNotWorkingException;

public interface Payment {
    void pay(String amount) throws SystemNotWorkingException;
    String getPaymentType();
}
