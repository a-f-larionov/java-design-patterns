package patterns.structural.adapter;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaySystemAdapterTest {

    @Test
    public void testGetBalance() {

        PaySystemBase paySystemBase = new PaySystemBase();
        PaySystemSecond paySystemSecond = new PaySystemSecond();

        PaySystemAdapter paySystemAdapter = new PaySystemAdapter(paySystemSecond);

        assertEquals(paySystemBase.getBalance(), 100);
        assertEquals(paySystemAdapter.getBalance(), 200);
    }
}