package com.aslihanhsr.paymentSystem;

public class CashPayment implements Payment {
    @Override
    public void pay(String amount) {
        System.out.println(amount+" ₺ is paid in cash.");
    }

    @Override
    public String getPaymentType() {
        return "Cash";
    }
}
