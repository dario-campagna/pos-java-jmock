package it.esteco.pos.domain;

public class Barcode {

    private final String barcodeAsText;

    public Barcode(String barcodeAsText) {
        this.barcodeAsText = barcodeAsText;
    }

    @Override
    public String toString() {
        return barcodeAsText;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Barcode) {
            Barcode that = (Barcode) obj;
            return this.barcodeAsText.equals(that.barcodeAsText);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 11 * barcodeAsText.hashCode() + 3;
    }
}
