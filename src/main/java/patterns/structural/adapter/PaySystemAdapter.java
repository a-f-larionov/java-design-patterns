package patterns.structural.adapter;

public class PaySystemAdapter implements IPaySystemBase {

    private PaySystemSecond secondObject;

    PaySystemAdapter(PaySystemSecond secondObject) {
        this.secondObject = secondObject;
    }

    @Override
    public long getBalance() {
        return secondObject.getMyBalance();
    }
}

