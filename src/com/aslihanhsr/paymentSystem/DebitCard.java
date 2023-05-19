package com.aslihanhsr.paymentSystem;

import com.aslihanhsr.paymentSystem.exceptionManagement.*;
import com.aslihanhsr.paymentSystem.domainConstants.*;

import java.util.Random;

public class DebitCard extends CardPayment{

    public DebitCard(String cardNumber, String expirationDate, String securityCode) {
        super(cardNumber, expirationDate, securityCode);
    }

    @Override
    public String getPaymentType() {
        return "Debit Card";
    }

    @Override
    public void pay(double amount) throws SystemNotWorkingException {
        Random randomNumber=new Random();
        int possibility= randomNumber.nextInt(0,50);
        if(possibility> DomainConstants.DEBIT_CARD_PAYMENT_POSSIBILITY){
            throw new SystemNotWorkingException("Transaction not available.");
        }else{
            System.out.println(amount+" payed.");
        }
    }
}
