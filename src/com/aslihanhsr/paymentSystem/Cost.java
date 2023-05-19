package com.aslihanhsr.paymentSystem;

import com.aslihanhsr.paymentSystem.exceptionManagement.*;

import java.util.Scanner;

public class Cost {

    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void pay(Payment payment) throws SystemNotWorkingException {
        amount=checkPaymentAmount();
        payment.pay(amount);
    }

    private String checkPaymentAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How much do you want to pay? (₺) : ");
        String amount = scanner.next();
        try {
            boolean validAmount = isValidAmount();
            if (!validAmount) {
                throw new InvalidAmountException("Amount must be in format (0.0)", amount);
            }
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage() + " - " + e.getAmount());
            checkPaymentAmount();
        }
        return amount;
    }

    private boolean isValidAmount() {
        for (char c : amount.toCharArray()) {
            if (c == ',') {
                return false;
            }
        }
        double convertedAmount=Double.parseDouble(amount);
        return !(convertedAmount < 0);
    }
}