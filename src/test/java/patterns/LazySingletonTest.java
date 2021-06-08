package patterns;

import org.junit.Test;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class LazySingletonTest {

    @Test
    public void testInstantiate() {
        LazySingleton lazySingleton1, lazySingleton2;

        lazySingleton1 = LazySingleton.getInstance();

        assertNotNull(lazySingleton1);
        assertSame(lazySingleton1.getClass(), LazySingleton.class);
    }

    @Test
    public void testSameObjectEveryRequest() {
        LazySingleton lazySingleton1, lazySingleton2;

        lazySingleton1 = LazySingleton.getInstance();
        lazySingleton2 = LazySingleton.getInstance();

        assertSame(lazySingleton1, lazySingleton2);
    }

    @Test
    public void testThreadSafe() throws InterruptedException {

        int threadsAmount = 1000;
        Set<LazySingleton> lazySingletonSet = Collections.newSetFromMap(new ConcurrentHashMap<>());

        ExecutorService executorService = Executors.newFixedThreadPool(threadsAmount);

        for (int i = 0; i < threadsAmount; i++) {
            executorService.submit(() -> {
                LazySingleton lazySingleton = LazySingleton.getInstance();
                lazySingletonSet.add(lazySingleton);
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        assertEquals(1, lazySingletonSet.size());
    }
}