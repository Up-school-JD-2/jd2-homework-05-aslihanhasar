package com.aslihanhsr.paymentSystem;

import com.aslihanhsr.paymentSystem.exceptionManagement.SystemNotWorkingException;

public interface Payment {
    void pay(double amount) throws SystemNotWorkingException;
    String getPaymentType();
}
