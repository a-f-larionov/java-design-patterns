package patterns.structural.proxy;

public class ExpensiveObjectProxy implements ExpensiveObject {

    private static ExpensiveObjectImpl object;

    public ExpensiveObjectImpl getOriginal() {
        if (object == null) {
            object = new ExpensiveObjectImpl();
        }
        return object;
    }

    @Override
    public void process() {
        getOriginal()
                .process();
    }
}
