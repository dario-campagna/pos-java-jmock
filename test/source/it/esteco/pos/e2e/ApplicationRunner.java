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

    public void start(String textCatalog) {
        System.setOut(new PrintStream(applicationOutputStream));
        Main.main(textCatalog);
    }

    void showsEmptyBarcodeError() {
        Scanner scanner = new Scanner(new BufferedInputStream(new ByteArrayInputStream(applicationOutputStream.toByteArray())));
        assertThat(scanner.nextLine(), is(equalTo("Scan error: empty barcode!")));
    }

    public void showsPriceMessage() {
        Scanner scanner = new Scanner(new BufferedInputStream(new ByteArrayInputStream(applicationOutputStream.toByteArray())));
        assertThat(scanner.nextLine(), is(equalTo("$11.50")));
    }

    public void showsProductNotFoundMessage(String barcode) {
        Scanner scanner = new Scanner(new BufferedInputStream(new ByteArrayInputStream(applicationOutputStream.toByteArray())));
        assertThat(scanner.nextLine(), is(equalTo(barcode + " not found!")));
    }

    public void showsTotal(String amount) {
        Scanner scanner = new Scanner(new BufferedInputStream(new ByteArrayInputStream(applicationOutputStream.toByteArray())));
        assertThat(scanner.nextLine(), is(equalTo(amount)));
    }
}
