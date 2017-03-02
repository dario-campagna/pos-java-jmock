package it.esteco.pos.e2e;

import java.io.ByteArrayInputStream;

public class FakeOperator {
    public void input(String barcode) {
        System.setIn(new ByteArrayInputStream(barcode.getBytes()));
    }
}
