package patterns.structural.adapter;

public class PaySystemSecond implements IPaySystemSecond {

    @Override
    public long getMyBalance() {
        return 200;
    }
}
