package com.aslihanhsr.paymentSystem;

import com.aslihanhsr.paymentSystem.exceptionManagement.*;

import java.util.Scanner;

public class PaymentTransactionService {
    private final Scanner scanner = new Scanner(System.in);
    private Cost cost;

    public void pay(Payment payment) throws SystemNotWorkingException {
        checkPaymentAmount();
        payment.pay(cost);
    }
    public String checkCardNumber()  {
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

    public String checkCardExpirationDate(){
        System.out.print("Enter the credit card expiration date (MM/yyyy) : ");
        String expirationDate = scanner.next();
        try {
            boolean validDateFormat=CardValidationTransactions.isDateFormatCorrect(expirationDate);
            if(!validDateFormat){
                throw new InvalidInputFormatException("The information must be entered in the correct format.");
            }
            boolean validExpirationDate = CardValidationTransactions.isValidExpirationDate(expirationDate);
            if (!validExpirationDate) {
                throw new InvalidCardExpirationDateException("The credit card may have expired.", expirationDate);
            }
        }catch (InvalidInputFormatException | InvalidCardExpirationDateException e) {
            System.out.println(e.getMessage());
            checkCardExpirationDate();
        }
        return expirationDate;
    }

    public String checkCardSecurityCode()  {
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

    private void checkPaymentAmount() {
        System.out.print("How much do you want to pay? (₺) : ");
        double amount = scanner.nextDouble();
        cost = new Cost(amount);
        try {
            boolean validAmount = cost.isValidAmount();
            if (!validAmount) {
                throw new InvalidAmountException("Amount must be in format (0.0)", amount);
            }
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage() + " - " + e.getAmount());
            checkPaymentAmount();
        }
    }
}
