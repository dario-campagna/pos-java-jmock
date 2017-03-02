package it.esteco.pos.e2e;

import java.io.ByteArrayInputStream;

public class FakeOperator {
    public void scan(String barcode) {
        System.setIn(new ByteArrayInputStream(barcode.getBytes()));
    }

    public void requestTotal() {
        System.setIn(new ByteArrayInputStream("TOTAL".getBytes()));
    }
}
