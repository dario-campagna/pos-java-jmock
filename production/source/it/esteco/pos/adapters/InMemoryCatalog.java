package it.esteco.pos.adapters;

import it.esteco.pos.domain.Catalog;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCatalog implements Catalog {

    private Map<String, String> priceByBarCode = new HashMap<>();

    @Override
    public String findPriceBy(String barcode) {
        return priceByBarCode.get(barcode);
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
        priceByBarCode.put(pair[0].trim(), pair[1].trim());
    }
}
