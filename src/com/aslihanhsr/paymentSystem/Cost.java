package com.aslihanhsr.paymentSystem;

import com.aslihanhsr.paymentSystem.exceptionManagement.*;

import java.util.Scanner;

public class Cost {

    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void pay(Payment payment) throws SystemNotWorkingException {
        amount=checkPaymentAmount();
        payment.pay(amount);
    }

    private double checkPaymentAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How much do you want to pay? (₺) : ");
        double amount = scanner.nextDouble();
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
        if (amount < 0) {
            return false;
        }
        String convertedAmount = Double.toString(amount);
        for (char c : convertedAmount.toCharArray()) {
            if (c == ',') {
                return false;
            }
        }
        return true;
    }
}