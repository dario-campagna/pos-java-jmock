package it.esteco.pos.domain;

public interface Catalog {
    Money findPriceBy(String barcode);
}
