package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepo {
    private List<Product> products;

    public ProductRepo() {
        this.products = new ArrayList<>();
        products.add(new Product("1", "Apfel"));
        products.add(new Product("2", "Banane"));
    }

    public Product addProduct(Product newProduct) {
        products.add(newProduct);
        return newProduct;
    }

    public Optional<Product> getProductById(String id) {
        return products.stream()
                .filter(product -> product.id().equals(id))
                .findFirst();
    }

    public void removeProduct(String id) {
        products.removeIf(product -> product.id().equals(id));
    }
}