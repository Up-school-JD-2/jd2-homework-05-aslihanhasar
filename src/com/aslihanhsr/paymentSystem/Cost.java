package com.aslihanhsr.paymentSystem;

public class Cost {
    private final double amount;
    public Cost(double amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return amount;
    }
    public boolean isValidAmount() {
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
