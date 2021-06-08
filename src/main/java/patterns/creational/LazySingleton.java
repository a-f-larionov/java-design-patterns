package patterns.creational;

/**
 * Design pattern LazySingleton.
 * Lazy and Thread safe LazySingleton
 */
public class LazySingleton {

    private static LazySingleton instance;

    synchronized public static LazySingleton getInstance() {

        if (instance == null) {
            instance = new LazySingleton();
        }

        return instance;
    }
}
