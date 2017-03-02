package it.esteco.pos;

import java.io.ByteArrayInputStream;

public class FakeScanner {
    public void scan(String barcode) {
        System.setIn(new ByteArrayInputStream(barcode.getBytes()));
    }
}
