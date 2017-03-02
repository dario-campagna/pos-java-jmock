package it.esteco.pos.e2e;

import it.esteco.pos.Main;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ApplicationRunner {
    private ByteArrayOutputStream applicationOutputStream = new ByteArrayOutputStream();
    private Scanner scanner;

    public void start(String textCatalog) {
        System.setOut(new PrintStream(applicationOutputStream));
        Main.main(textCatalog);
        scanner = new Scanner(new BufferedInputStream(new ByteArrayInputStream(applicationOutputStream.toByteArray())));
    }

    void showsEmptyBarcodeError() {
        assertThat(scanner.nextLine(), is(equalTo("Scan error: empty barcode!")));
    }

    public void showsPriceMessage(String price) {
        assertThat(scanner.nextLine(), is(equalTo(price)));
    }

    public void showsProductNotFoundMessage(String barcode) {
        assertThat(scanner.nextLine(), is(equalTo(barcode + " not found!")));
    }

    public void showsTotal(String amount) {
        assertThat(scanner.nextLine(), is(equalTo(amount)));
    }
}
