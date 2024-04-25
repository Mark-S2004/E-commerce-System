package EcommerceSystem;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("System Test Suite")
@SelectClasses({
        ProductTest.class,
        ProductCatalogTest.class,
        ShoppingCartTest.class,
        PaymentProcessorTest.class,
        PlacedOrderTest.class,
        OrderManagementTest.class,
        AccountTest.class,
        AccountManagerTest.class
})
public class SystemSuiteTest {
}