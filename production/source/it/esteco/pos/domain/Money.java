package it.esteco.pos.domain;

public class Money {
    private final int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public Money add(Money money) {
        return new Money(amount + money.amount);
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Money) {
            Money that = (Money) obj;
            return this.amount == that.amount;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 13 * amount + 5;
    }
}
