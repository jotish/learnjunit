import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

/**
 * Created by jotishsuthar on 03/09/17.
 */
@RunWith(JUnitParamsRunner.class)
public class MoneyTest {


    private final static int VALID_AMOUNT = 5;
    private final static String VALID_CURRENCY = "USD";

    private static final Object[] getMoney() {
        return new Object[] {
                new Object[] {10, "USD"},
                new Object[] {20, "EUR"}
        };
    }
    private static final Object[] getInvalidAmount() {
        return new Integer[][]{{-12387}, {-5}, {-1}};
    }


    private static final Object[] getInvalidCurrency() {
        return new String[][]{{null}, {""}};
    }

    @Test
    @Parameters(method = "getMoney")
    public void constructorShouldSetAmountAndCurrency(
            int amount, String currency) {
        Money money = new Money(amount, currency);
        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());
    }


    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidAmount")
    public void constructorShouldThrowIAEForInvalidAmount(
            int invalidAmount) {
        new Money(invalidAmount, VALID_CURRENCY);
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidCurrency")
    public void constructorShouldThrowIAEForInvalidCurrency(
            String invalidCurrency) {
        new Money(VALID_AMOUNT, invalidCurrency);
    }
}
