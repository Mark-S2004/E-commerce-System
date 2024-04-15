public class PaymentProcessor {
    private boolean paymentGatewayConnected;

    public PaymentProcessor() {
        // Simulating connection to the payment gateway
        paymentGatewayConnected = true;
    }

    public boolean processPayment(double amount) {
        if (paymentGatewayConnected) {
            // Simulating payment processing logic
            if (amount > 0) {
                // Payment successful
                return true;
            } else {
                // Payment failed
                return false;
            }
        } else {
            // Payment gateway not connected
            return false;
        }
    }

    public void connectPaymentGateway() {
        // Simulating connection to the payment gateway
        paymentGatewayConnected = true;
    }

    public void disconnectPaymentGateway() {
        // Simulating disconnection from the payment gateway
        paymentGatewayConnected = false;
    }
}