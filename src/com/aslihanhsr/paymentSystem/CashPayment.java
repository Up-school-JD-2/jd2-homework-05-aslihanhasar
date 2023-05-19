package com.aslihanhsr.paymentSystem;

public class CashPayment implements Payment {
    @Override
    public void pay(Cost cost) {
        System.out.println(cost.getAmount()+" is payed in cash.");
    }

    @Override
    public String getPaymentType() {
        return "Cash";
    }
}
