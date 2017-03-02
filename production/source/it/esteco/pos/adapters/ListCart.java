package it.esteco.pos.adapters;

import it.esteco.pos.domain.Cart;
import it.esteco.pos.domain.Money;

import java.util.ArrayList;
import java.util.List;

public class ListCart implements Cart {

    private final List<Money> content = new ArrayList<>();

    @Override
    public Money total() {
        return content.stream().reduce(new Money(0), (a,b) -> a.add(b));
    }

    @Override
    public void add(Money money) {
        content.add(money);
    }
}
