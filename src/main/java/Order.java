package main.java;

import java.util.List;

public record Order(
        String id,
        List<Product> products,

        OrderStatus status
) {
    public Order(String id, List<Product> products, OrderStatus status) {
        this.id = id;
        this.products = products;
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }

}

