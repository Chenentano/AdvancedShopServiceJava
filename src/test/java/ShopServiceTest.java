package test.java;
import main.java.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

class ShopServiceTest {

    @Test
    void addOrderTest() {
        //GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1");

        //WHEN
        Order actual = shopService.addOrder(productsIds);

        //THEN
        Order expected = new Order("-1", List.of(new Product("1", "Apfel")), OrderStatus.PROCESSING);
        assertEquals(expected.products(), actual.products());
        assertNotNull(expected.id());
    }

/*    @Test
    void addOrderTest_whenInvalidProductId_expectNull() {
        // GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1", "2");

        // WHEN
        Order actual = shopService.addOrder(productsIds);

        // THEN
        Assertions.assertNull(actual);
    }*/
}
