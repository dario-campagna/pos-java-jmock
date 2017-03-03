package it.esteco.pos.domain;

public class MessageFormatter {

    public String formatPrice(Money money) {
        String cents = String.valueOf(money.getAmount());
        return "$" + integerPart(cents) + "." + decimalPart(cents);
    }

    public String formatNotFound(String barcode) {
        return barcode + " not found!";
    }

    public String emptyBarcode() {
        return "Scan error: empty barcode!";
    }

    private String integerPart(String cents) {
        if (hasLessThanThreeDigits(cents)) {
            return "0";
        }
        return cents.substring(0, cents.length() - 2);
    }

    private String decimalPart(String cents) {
        if (hasOneDigit(cents)) {
            return "0" + cents;
        }
        return cents.substring(cents.length() - 2, cents.length());
    }

    private boolean hasOneDigit(String cents) {
        return cents.length() == 1;
    }

    private boolean hasLessThanThreeDigits(String cents) {
        return cents.length() < 3;
    }
}
