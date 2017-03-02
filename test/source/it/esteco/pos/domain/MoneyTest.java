package it.esteco.pos.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MoneyTest {

    @Test
    public void add() throws Exception {
        Money money = new Money(5);
        Money sum = money.add(new Money(1));
        assertThat(sum, is(equalTo(new Money(6))));
    }
}
