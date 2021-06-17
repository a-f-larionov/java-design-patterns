package patterns.structural.adapter;

import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;

public class PaySystemSecondTest extends TestCase {

    public void testGetMyBalance() {
        PaySystemSecond paySystemSecond = new PaySystemSecond();

        long balance = paySystemSecond.getMyBalance();

        assertEquals(balance, 200);
    }
}