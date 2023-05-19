package com.aslihanhsr.paymentSystem;

import com.aslihanhsr.paymentSystem.exceptionManagement.*;
import com.aslihanhsr.paymentSystem.domainConstants.*;

import java.util.Random;

public class CreditCard extends CardPayment{

    public CreditCard(String cardNumber, String expirationDate, String securityCode) {
        super(cardNumber, expirationDate, securityCode);
    }

    @Override
    public String getPaymentType() {
        return "Credit Card";
    }

    @Override
    public void pay(Cost cost) throws SystemNotWorkingException {
        Random randomNumber=new Random();
        int possibility=randomNumber.nextInt(0,100);
        if(possibility> DomainConstants.CREDIT_CARD_PAYMENT_POSSIBILITY){
            throw new SystemNotWorkingException("Transaction not available.");
        }else{
            System.out.println(cost.getAmount()+" payed.");
        }
    }
}
