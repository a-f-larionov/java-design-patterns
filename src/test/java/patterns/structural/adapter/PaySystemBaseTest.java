package patterns.structural.adapter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaySystemBaseTest {

    @Test
    public void testGetBalance() {

        PaySystemBase paySystemBase = new PaySystemBase();

        long balance = paySystemBase.getBalance();

        assertEquals(balance, 100);
    }
}