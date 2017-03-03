package it.esteco.pos.adapters;

import it.esteco.pos.domain.Barcode;
import it.esteco.pos.domain.Catalog;
import it.esteco.pos.domain.Money;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCatalog implements Catalog {

    private Map<Barcode, Money> priceByBarcode = new HashMap<>();

    @Override
    public Money findPriceBy(Barcode barcode) {
        return priceByBarcode.get(barcode);
    }

    public static InMemoryCatalog from(String textCatalog) {
        InMemoryCatalog catalog = new InMemoryCatalog();
        for (String entry : entriesIn(textCatalog)) {
            catalog.addEntry(entry);
        }
        return catalog;
    }

    private static String[] entriesIn(String textCatalog) {
        return textCatalog.split(";");
    }

    private void addEntry(String entry) {
        String[] pair = entry.split(",");
        priceByBarcode.put(new Barcode(pair[0].trim()), new Money(Integer.parseInt(pair[1].trim())));
    }
}
