package org.ecommerce;

public class Orders {
    private String orderId;
    private String userEmail;

    public Orders(String orderId, String userEmail) {
        this.orderId = orderId;
        this.userEmail = userEmail;
    }

    // Getters and setters

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}