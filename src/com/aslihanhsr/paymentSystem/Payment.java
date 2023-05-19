package com.aslihanhsr.paymentSystem;

import com.aslihanhsr.paymentSystem.exceptionManagement.SystemNotWorkingException;

public interface Payment {
    void pay(String amount) throws SystemNotWorkingException;
    String getPaymentType();
}
