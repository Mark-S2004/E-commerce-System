package EcommerceSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentProcessorTest {
    private PaymentProcessor paymentProcessor;

    @BeforeEach
    void setup() {
        paymentProcessor = new PaymentProcessor();
    }

    @Test
    public void testProcessPaymentWithValidAmount() {
        assertTrue(paymentProcessor.processPayment(100.0));
    }

    @Test
    public void testProcessPaymentWithZeroAmount() {
        assertFalse(paymentProcessor.processPayment(0.0));
    }

    @Test
    public void testProcessPaymentWithNegativeAmount() {
        assertFalse(paymentProcessor.processPayment(-100.0));
    }

    @Test
    public void testDisconnectGatewayProcessPayment() {
        paymentProcessor.disconnectPaymentGateway();
        assertFalse(paymentProcessor.processPayment(-100.0));
    }

    @Test
    void connectPaymentGateway() {
        paymentProcessor.connectPaymentGateway();
        assertTrue(paymentProcessor.isPaymentGatewayConnected());
    }

    @Test
    void disconnectPaymentGateway() {
        paymentProcessor.disconnectPaymentGateway();
        assertFalse(paymentProcessor.isPaymentGatewayConnected());
    }
}