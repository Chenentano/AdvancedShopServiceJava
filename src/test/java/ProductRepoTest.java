package test.java;

import main.java.*;
import main.java.ProductRepo;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductRepoTest {

    @Test
    void getProductById() {
        // GIVEN
        ProductRepo repo = new ProductRepo();

        // WHEN
        Optional<Product> actualOptional = repo.getProductById("1");

        // THEN
        assertTrue(actualOptional.isPresent()); // Check if Optional contains a value
        Product actual = actualOptional.get(); // Extract the Product from Optional
        Product expected = new Product("1", "Apfel");
        assertEquals(expected, actual);
    }

    @Test
    void addProduct() {
        // GIVEN
        ProductRepo repo = new ProductRepo();
        Product newProduct = new Product("3", "Orange");

        // WHEN
        Product actual = repo.addProduct(newProduct);

        // THEN
        Product expected = new Product("3", "Orange");
        assertEquals(expected, actual);

        // Retrieve the product from Optional and compare
        Optional<Product> optionalProduct = repo.getProductById("3");
        assertTrue(optionalProduct.isPresent());
        assertEquals(expected, optionalProduct.get());
    }

    @Test
    void removeProduct() {
        // GIVEN
        ProductRepo repo = new ProductRepo();

        // WHEN
        repo.removeProduct("1");

        // THEN
        assertFalse(repo.getProductById("1").isPresent());
    }
}