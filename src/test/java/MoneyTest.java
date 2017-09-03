import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jotishsuthar on 03/09/17.
 */
public class MoneyTest {

    @Test
    public void constructorShouldSetAmountAndCurrency(){
        Money money = new Money(10, "USD");
        assertEquals(10, money.getAmount());
        assertEquals("USD", money.getCurrency());
    }
}
