package it.esteco.pos.adapters;

import it.esteco.pos.domain.Money;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InMemoryCatalogTest {

    @Test
    public void findPriceByBarcode() throws Exception {
        InMemoryCatalog catalog = InMemoryCatalog.from("12345,115;54321,799");

        assertThat(catalog.findPriceBy("12345"), is(equalTo(new Money(115))));
        assertThat(catalog.findPriceBy("54321"), is(equalTo(new Money(799))));
    }
}
