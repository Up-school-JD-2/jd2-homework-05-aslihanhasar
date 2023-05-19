package com.aslihanhsr.paymentSystem;

import com.aslihanhsr.paymentSystem.exceptionManagement.SystemNotWorkingException;

public interface Payment {
    void pay(Cost cost) throws SystemNotWorkingException;
    String getPaymentType();
}
