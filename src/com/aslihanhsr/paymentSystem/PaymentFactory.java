package com.aslihanhsr.paymentSystem;

import com.aslihanhsr.paymentSystem.customExceptions.NoSuchPaymentMethodFoundException;

public class PaymentFactory {

    private static final PaymentTransactionService service = new PaymentTransactionService();

    public static Payment getAPaymentMethod(int method) {
        Payment paymentMethod = null;
        try {
            if (checkPaymentMethod(method)) {
                switch (method) {
                    case 1 -> paymentMethod = createACreditCard();
                    case 2 -> paymentMethod = getADebitCard();
                    case 3 -> paymentMethod = getACashPayment();
                }
            }
        } catch (NoSuchPaymentMethodFoundException e) {
            System.out.println(e.getMessage());
        }
        return paymentMethod;
    }

    private static boolean checkPaymentMethod(int method) throws NoSuchPaymentMethodFoundException {
        if (method < 0 || method > 3) {
            throw new NoSuchPaymentMethodFoundException("Enter a valid method.");
        }
        return true;
    }

    private static CreditCard createACreditCard() {
        String cardNumber = service.checkCardNumber();
        String expirationDate = service.checkCardExpirationDate();
        String securityCode = service.checkCardSecurityCode();
        return new CreditCard(cardNumber, expirationDate, securityCode);
    }

    private static DebitCard getADebitCard() {
        return new DebitCard("5656454456454", "11/2025", "156");
    }

    private static CashPayment getACashPayment() {
        return new CashPayment();
    }
}
