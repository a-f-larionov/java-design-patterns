package patterns.structural.proxy;

import junit.framework.TestCase;
import nl.altindag.log.LogCaptor;
import org.junit.Test;
import org.mockito.Mockito;

public class ExpensiveObjectProxyTest {

    @Test
    public void testCallOriginalProcess() {

        LogCaptor logCaptor = LogCaptor.forClass(ExpensiveObjectImpl.class);

        ExpensiveObjectProxy proxy = Mockito.spy(ExpensiveObjectProxy.class);
        ExpensiveObjectImpl impl = Mockito.mock(ExpensiveObjectImpl.class);

        Mockito.when(proxy.getOriginal()).thenReturn(impl);

        proxy.process();

        Mockito.verify(impl).process();
    }
}