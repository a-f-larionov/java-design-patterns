package patterns;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Laze Safe threaded Multiton
 * Example like Multiton from java-design-patterns.com
 * but lazy
 *
 * @link https://java-design-patterns.com/patterns/multiton/
 */
public class Multiton {

    private static final Map<Type, Multiton> instances =
            new ConcurrentHashMap<>();

    public enum Type {
        TypeA, TypeB
    }

    private Type type;

    private Multiton(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    synchronized public static Multiton getInstance(Type type) {

        if (!instances.containsKey(type)) {
            instances.put(type, new Multiton(type));
        }

        return instances.get(type);
    }
}
