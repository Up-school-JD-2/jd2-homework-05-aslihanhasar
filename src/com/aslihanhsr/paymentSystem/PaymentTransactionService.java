package com.aslihanhsr.paymentSystem;

import com.aslihanhsr.paymentSystem.customExceptions.*;

import java.util.Scanner;

public class PaymentTransactionService {
    private final Scanner scanner = new Scanner(System.in);

    public String checkCardNumber() {
        System.out.print("Enter the credit card number : ");
        String cardNumber = scanner.next();
        try {
            boolean validCardNumber = CardValidationTransactions.isValidCardNumber(cardNumber);
            if (!validCardNumber) {
                throw new InvalidCardNumberException("The card number must consist of 16 digits. ", cardNumber);
            }
        } catch (InvalidCardNumberException e) {
            System.out.println(e.getMessage());
            checkCardNumber();
        }
        return cardNumber;
    }

    public String checkCardExpirationDate() {
        System.out.print("Enter the credit card expiration date (MM/yyyy) : ");
        String expirationDate = scanner.next();
        try {
            boolean validDateFormat = CardValidationTransactions.isDateFormatCorrect(expirationDate);
            if (!validDateFormat) {
                throw new InvalidInputFormatException("The information must be entered in the correct format.");
            }
            boolean validExpirationDate = CardValidationTransactions.isValidExpirationDate(expirationDate);
            if (!validExpirationDate) {
                throw new InvalidCardExpirationDateException("The credit card may have expired.", expirationDate);
            }
        } catch (InvalidInputFormatException | InvalidCardExpirationDateException e) {
            System.out.println(e.getMessage());
            checkCardExpirationDate();
        }
        return expirationDate;
    }

    public String checkCardSecurityCode() {
        System.out.print("Enter the CVV : ");
        String securityCode = scanner.next();
        try {
            boolean validCVV = CardValidationTransactions.isValidCVV(securityCode);
            if (!validCVV) {
                throw new InvalidCVVException("CVV must consist of 3 digits.");
            }
        } catch (InvalidCVVException e) {
            System.out.println(e.getMessage());
            checkCardSecurityCode();
        }
        return securityCode;
    }
}
