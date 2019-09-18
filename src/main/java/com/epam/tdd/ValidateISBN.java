package com.epam.tdd;

public class ValidateISBN {

    public static final int SHORT_ISBN_MYLTIPLIER = 11;
    public static final int LONG_ISBN_MYLTIPLIER = 10;
    public static final int SHORT_ISBN_LENGTH = 10;
    public static final int LONG_ISBN_LENGTH = 13;
    public static final String MESSAGE_WRONG_DIGITS_IN_NUMBER = "ISBN numbers must contains only digits";
    public static final String MESSAGE_WRONG_ISBN_LENGTH =
            "ISBN numbers has wrong long. Must be " +
                    SHORT_ISBN_LENGTH +
                    " or " +
                    LONG_ISBN_LENGTH +
                    " digits";

    private boolean isValidLongISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
            char ch = isbn.charAt(i);
            if (!Character.isDigit(ch)) {
                if (i == LONG_ISBN_LENGTH - 1 && ch == 'X') {
                    total += 10;
                    break;
                }
                throw new NumberFormatException(MESSAGE_WRONG_DIGITS_IN_NUMBER);
            }
            total += Character.getNumericValue(ch) * (i % 2 == 0 ? 1 : 3);
        }
        return total % LONG_ISBN_MYLTIPLIER == 0;
    }

    private boolean isValidShortISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
            char ch = isbn.charAt(i);
            if (!Character.isDigit(ch)) {
                if (i == SHORT_ISBN_LENGTH - 1 && ch == 'X') {
                    total += 10;
                    break;
                }
                throw new NumberFormatException(MESSAGE_WRONG_DIGITS_IN_NUMBER);
            }
            total += Character.getNumericValue(ch) * (SHORT_ISBN_LENGTH - i);
        }
        return total % SHORT_ISBN_MYLTIPLIER == 0;
    }

    public boolean checkISBN(String isbn) {
        switch (isbn.length()) {
            case SHORT_ISBN_LENGTH:
                return isValidShortISBN(isbn);
            case LONG_ISBN_LENGTH:
                return isValidLongISBN(isbn);
            default:
                throw new NumberFormatException(MESSAGE_WRONG_ISBN_LENGTH);
        }
    }
}
