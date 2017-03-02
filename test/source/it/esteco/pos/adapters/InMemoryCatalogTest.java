package it.esteco.pos.adapters;

import it.esteco.pos.adapters.InMemoryCatalog;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InMemoryCatalogTest {

    @Test
    public void findPriceByBarcode() throws Exception {
        InMemoryCatalog catalog = InMemoryCatalog.from("12345,$11.50;54321,$7.99");

        assertThat(catalog.findPriceBy("12345"), is(equalTo("$11.50")));
        assertThat(catalog.findPriceBy("54321"), is(equalTo("$7.99")));
    }
}
