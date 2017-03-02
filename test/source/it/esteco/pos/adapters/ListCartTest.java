package it.esteco.pos.adapters;

import it.esteco.pos.domain.Money;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ListCartTest {

    private final ListCart cart = new ListCart();

    @Test
    public void totalWhenEmpty() throws Exception {
        assertThat(cart.total(), is(equalTo(new Money(0))));
    }

    @Test
    public void totalWhenProductsInCart() throws Exception {
        cart.add(new Money(1000));
        cart.add(new Money(500));
        assertThat(cart.total(), is(equalTo(new Money(1500))));
    }
}
