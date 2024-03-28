package main.java;

import java.util.List;

public record Order(
        String id,
        List<Product> products,

        OrderStatus status
) {
    // Constructor with status parameter
    public Order(String id, List<Product> products, OrderStatus status) {
        this.id = id;
        this.products = products;
        this.status = status;
    }
}

