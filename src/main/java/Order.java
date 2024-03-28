package main.java;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record Order(
        String id,
        List<Product> products,
        OrderStatus status,
        Instant timestamp // Adding timestamp field
) {
    // Constructor with timestamp parameter
    public Order(String id, List<Product> products, OrderStatus status) {
        this(id, products, status, Instant.now()); // Initialize timestamp with current time
    }
    public OrderStatus getStatus() {
        return status;
    }
}

