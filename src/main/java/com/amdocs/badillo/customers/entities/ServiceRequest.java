package com.amdocs.badillo.customers.entities;

public class ServiceRequest {

    private final long userId;
    private final long productId;
    private final long actionId;



    public ServiceRequest(long userId, long productId, long actionId) {
        this.userId = userId;
        this.productId = productId;
        this.actionId = actionId;
    }

    public long getUserId() {
        return userId;
    }

    public long getProductId() {
        return productId;
    }

    public long getActionId() {
        return actionId;
    }
}
