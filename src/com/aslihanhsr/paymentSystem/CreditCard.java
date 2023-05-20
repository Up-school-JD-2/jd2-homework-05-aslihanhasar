package com.aslihanhsr.paymentSystem;

import com.aslihanhsr.paymentSystem.customExceptions.*;
import com.aslihanhsr.paymentSystem.domainConstants.*;

import java.util.Random;

public class CreditCard extends CardPayment {

    public CreditCard(String cardNumber, String expirationDate, String securityCode) {
        super(cardNumber, expirationDate, securityCode);
    }

    @Override
    public String getPaymentType() {
        return "Credit Card";
    }

    @Override
    public void pay(String amount) throws SystemNotWorkingException {
        Random randomNumber = new Random();
        int possibility = randomNumber.nextInt(0, 100);
        if (possibility > DomainConstants.CREDIT_CARD_PAYMENT_POSSIBILITY) {
            throw new SystemNotWorkingException("Transaction not available.");
        } else {
            System.out.println(amount + " ₺ is paid.");
        }
    }
}
