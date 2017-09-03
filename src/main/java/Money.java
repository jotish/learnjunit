/**
 * Created by jotishsuthar on 03/09/17.
 */
public class Money {
    private final int amount;
    private final String currency;
    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
    public int getAmount() {
        return amount;
    }
    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (amount != money.amount) return false;
        return currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + currency.hashCode();
        return result;
    }
}
