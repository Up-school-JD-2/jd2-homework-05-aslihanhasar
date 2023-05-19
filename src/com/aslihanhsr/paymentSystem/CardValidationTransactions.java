package com.aslihanhsr.paymentSystem;

import com.aslihanhsr.paymentSystem.domainConstants.DomainConstants;

import java.time.LocalDate;

public class CardValidationTransactions {
    private static final LocalDate CURRENT_DATE = LocalDate.now();
    private static final int currentMonth;
    private static final int currentYear;

    static {
        currentMonth = getCurrentMonth();
        currentYear = getCurrentYear();
    }

    public static boolean isValidCardNumber(String cardNumber) {
        if (cardNumber.length() != DomainConstants.CREDIT_CARD_NUMBER_DIGIT) {
            return false;
        }
        return containsDigits(cardNumber);
    }

    public static boolean isValidExpirationDate(String expirationDate) {
        String[] date = expirationDate.split("/");
        int expirationMonth = Integer.parseInt(date[0]);
        int expirationYear = Integer.parseInt(date[1]);

        if (expirationMonth < 0 || expirationMonth > 12) {
            return false;
        }
        if ((expirationYear == currentYear) && (expirationMonth < currentMonth)) {
            return false;
        } else {
            return expirationYear >= currentYear;
        }
    }

    public static boolean isValidCVV(String text) {
        if (text.length() != DomainConstants.CREDIT_CARD_CVV_DIGIT) {
            return false;
        }
        return containsDigits(text);
    }

    public static boolean isDateFormatCorrect(String text) {
        return text.contains("/");
    }

    private static int getCurrentYear() {
        return CURRENT_DATE.getYear();
    }

    private static int getCurrentMonth() {
        return CURRENT_DATE.getMonthValue();
    }

    private static boolean containsDigits(String text) {
        for (char c : text.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
