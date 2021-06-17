package patterns.structural.adapter;

public class PaySystemBase implements IPaySystemBase {

    @Override
    public long getBalance() {
        return 100;
    }
}
