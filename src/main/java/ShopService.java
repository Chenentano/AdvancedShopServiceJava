package main.java;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class ShopService {
    private ProductRepo productRepo = new ProductRepo();
    private OrderRepo orderRepo = new OrderMapRepo();

    public Order addOrder(List<String> productIds) {
        List<Product> validProducts = new ArrayList<>();

        for (String productId : productIds) {
            Optional<Product> productToOrder = productRepo.getProductById(productId);

            if (productToOrder.isEmpty()) {
                throw new IllegalArgumentException("Product with ID " + productId + " does not exist.");
            }

            validProducts.add(productToOrder.get());
        }

        if (validProducts.isEmpty()) {
            return null;
        }

        Order newOrder = new Order(UUID.randomUUID().toString(), validProducts, OrderStatus.PROCESSING);
        return orderRepo.addOrder(newOrder);
    }
    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orderRepo.getAllOrders().stream()
                .filter(order -> order.status() == status)
                .collect(Collectors.toList());
    }

    public Order updateOrder(String orderId, OrderStatus newStatus) {
        Optional<Order> optionalOrder = Optional.ofNullable(orderRepo.getOrderById(orderId));
        if (optionalOrder.isPresent()) {
            Order existingOrder = optionalOrder.get();
            Order updatedOrder = new Order(existingOrder.id(), existingOrder.products(), newStatus);
            return orderRepo.updateOrder(updatedOrder);
        } else {
            throw new IllegalArgumentException("Order with ID " + orderId + " does not exist.");
        }
    }
}