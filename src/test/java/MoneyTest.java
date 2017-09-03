import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by jotishsuthar on 03/09/17.
 */
@RunWith(JUnitParamsRunner.class)
public class MoneyTest {

    private static final Object[] getMoney() {
        return new Object[] {
                new Object[] {10, "USD"},
                new Object[] {20, "EUR"}
        };
    }

    @Test
    @Parameters(method = "getMoney")
    public void constructorShouldSetAmountAndCurrency(
            int amount, String currency) {
        Money money = new Money(amount, currency);
        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());
    }
}
