package it.esteco.pos;

import java.util.Scanner;

public class Main {

    private PointOfSale pointOfSale = new PointOfSale(new InMemoryCatalog(), new ConsoleDisplay());

    public static void main(String... args) {
        Main main = new Main();
        main.start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            pointOfSale.onBarcode(scanner.nextLine());
        }
    }


}
