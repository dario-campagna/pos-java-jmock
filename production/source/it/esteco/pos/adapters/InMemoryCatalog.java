package it.esteco.pos.adapters;

import it.esteco.pos.domain.Catalog;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCatalog implements Catalog {

    private Map<String, String> priceByBarCode = new HashMap<String, String>(){{
        put("12345", "$11.50");
    }};

    @Override
    public String findPriceBy(String barcode) {
        return priceByBarCode.get(barcode);
    }
}
