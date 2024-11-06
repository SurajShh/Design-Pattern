// Target interface
interface PaymentProcessor {
    void pay(int amount);
}

// Adaptee
class NewPaymentGateway {
    public void processPayment(int amount) {
        System.out.println("Processing payment of " + amount + " via New Payment Gateway.");
    }
}

// Adapter
class PaymentAdapter implements PaymentProcessor {
    private final NewPaymentGateway gateway;

    public PaymentAdapter(NewPaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void pay(int amount) {
        gateway.processPayment(amount);
    }
}

// Client code
public class AdapterExample {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentAdapter(new NewPaymentGateway());
        processor.pay(500);  // Using new gateway via adapter
    }
}
