package patterns;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultitonTest extends TestCase {

    @Test
    public void testInstantiateAll() {

        Multiton multiton;

        for (Multiton.Type type : Multiton.Type.values()) {

            multiton = Multiton.getInstance(type);

            assertNotNull(multiton);
            assertSame(multiton.getClass(), Multiton.class);
        }
    }

    @Test
    public void testSameObjectEveryInstantiations() {

        Multiton multiton1, multiton2;

        for (Multiton.Type type : Multiton.Type.values()) {
            multiton1 = Multiton.getInstance(type);
            multiton2 = Multiton.getInstance(type);

            assertSame(multiton1, multiton2);
        }
    }

    @Test
    public void testExpectedTypeReturned() {
        Multiton multiton;

        for (Multiton.Type type : Multiton.Type.values()) {

            multiton = Multiton.getInstance(type);

            assertEquals(multiton.getType(), type);
        }
    }

    @Test
    public void testSafeThread() throws InterruptedException {

        for (Multiton.Type type : Multiton.Type.values()) {

            testSafeThreadForOneType(type);
        }
    }

    private void testSafeThreadForOneType(Multiton.Type type) throws InterruptedException {
        int threadsAmount = 1000;
        Set<Multiton> multitonSet = Collections.newSetFromMap(new ConcurrentHashMap<>());

        ExecutorService executorService = Executors.newFixedThreadPool(threadsAmount);

        for (int i = 0; i < threadsAmount; i++) {
            executorService.submit(() -> {

                Multiton multiton = Multiton.getInstance(type);
                multitonSet.add(multiton);
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        assertEquals(1, multitonSet.size());
    }
}