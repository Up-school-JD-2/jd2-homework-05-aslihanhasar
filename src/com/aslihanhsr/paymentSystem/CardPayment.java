package com.aslihanhsr.paymentSystem;

public abstract class CardPayment implements Payment {
    protected final String cardNumber;
    protected final String expirationDate;
    protected final String securityCode;

    public CardPayment(String cardNumber, String expirationDate, String securityCode) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("****** Card Information ******");
        sb.append("Card Number= ").append(cardNumber).append('\n');
        sb.append("Expiration Date= ").append(expirationDate).append('\n');
        sb.append("SecurityCode= ").append(securityCode).append('\n');
        return sb.toString();
    }
}
