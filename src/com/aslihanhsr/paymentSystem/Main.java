package com.aslihanhsr.paymentSystem;

import com.aslihanhsr.paymentSystem.exceptionManagement.SystemNotWorkingException;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Cost cost=new Cost();
    private static Payment paymentMethod;

    public static void main(String[] args) {
        startProgram();
        boolean repeatTransaction=true;
        while (repeatTransaction) {
            try {
                cost.pay(paymentMethod);
                repeatTransaction=false;
            } catch (SystemNotWorkingException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static StringBuilder printMenu() {
        final StringBuilder str = new StringBuilder();
        str.append("*********** Welcome to the FastPayGate ***********").append("\n");
        str.append("  Payment Methods in FastPayGate").append("\n");
        str.append(" 1 - Credit Card").append("\n");
        str.append(" 2 - Debit Card").append("\n");
        str.append(" 3 - Cash").append("\n");
        return str;
    }

    private static void startProgram() {
        StringBuilder menuMessage = printMenu();
        boolean validMethod = false;
        do {
            System.out.println(menuMessage);
            System.out.print("Your choice: ");
            int method = scanner.nextInt();
            paymentMethod = PaymentFactory.getAPaymentMethod(method);
            if (paymentMethod != null) {
                System.out.println("Your payment method: "+paymentMethod.getPaymentType());
                validMethod = true;
            }
        } while (!validMethod);
    }

}
