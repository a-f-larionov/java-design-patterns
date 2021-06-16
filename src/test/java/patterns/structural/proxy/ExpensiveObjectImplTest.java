package patterns.structural.proxy;

import nl.altindag.log.LogCaptor;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpensiveObjectImplTest {

    @Test
    public void testProcess() {

        LogCaptor logCaptor = LogCaptor.forClass(ExpensiveObjectImpl.class);

        ExpensiveObjectImpl expensiveObject = new ExpensiveObjectImpl();

        assertEquals(logCaptor.getInfoLogs().size(), 1);
        assertEquals(logCaptor.getInfoLogs().get(0), "Heavy init");

        expensiveObject.process();

        assertEquals(logCaptor.getInfoLogs().size(), 2);
        assertEquals(logCaptor.getInfoLogs().get(1), "Process expensive object impl");
    }
}