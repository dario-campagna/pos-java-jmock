package it.esteco.pos.adapters;

import it.esteco.pos.domain.Display;
import it.esteco.pos.domain.Money;

public class ConsoleDisplay implements Display {

    @Override
    public void displayPrice(Money price) {
        System.out.println("$" + MoneyFormatter.format(price));
    }

    @Override
    public void displayProductNotFound(String barcode) {
        System.out.println(barcode + " not found!");
    }

    @Override
    public void displayEmptyBarcodeError() {
        System.out.println("Scan error: empty barcode!");
    }

    private static class MoneyFormatter {

        public static String format(Money money) {
            String cents = String.valueOf(money.getAmount());
            return integerPart(cents) + "." + decimalPart(cents);
        }

        private static String integerPart(String cents) {
            if (hasLessThanThreeDigits(cents)) {
                return "0";
            }
            return cents.substring(0, cents.length() - 2);
        }

        private static String decimalPart(String cents) {
            if (hasOneDigit(cents)) {
                return "0" + cents;
            }
            return cents.substring(cents.length() - 2, cents.length());
        }

        private static boolean hasOneDigit(String cents) {
            return cents.length() == 1;
        }

        private static boolean hasLessThanThreeDigits(String cents) {
            return cents.length() < 3;
        }
    }


}
