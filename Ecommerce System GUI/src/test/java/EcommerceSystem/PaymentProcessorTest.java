package EcommerceSystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentProcessorTest {
    @Test
    public void testProcessPaymentWithValidAmount() {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        assertTrue(paymentProcessor.processPayment(100.0));
    }

    @Test
    public void testProcessPaymentWithZeroAmount() {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        assertFalse(paymentProcessor.processPayment(0.0));
    }

    @Test
    public void testProcessPaymentWithNegativeAmount() {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        assertFalse(paymentProcessor.processPayment(-100.0));
    }
}