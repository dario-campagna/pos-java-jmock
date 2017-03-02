package it.esteco.pos.domain;

public interface Cart {
    Money total();

    void add(Money money);
}
