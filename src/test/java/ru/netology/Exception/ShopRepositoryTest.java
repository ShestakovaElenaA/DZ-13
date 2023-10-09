package ru.netology.Exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void removeNonExistentObjectTest() {
        Product[] products = new Product[2];
        Product product1 = new Product(1, "йогурт", 55);
        Product product2 = new Product(2, "булка", 45);
        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(product1);
        shopRepository.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> shopRepository.remove(3));
    }

    @Test
    public void removeExistentObjectTest() {
        Product[] products = new Product[2];
        Product product1 = new Product(1, "йогурт", 55);
        Product product2 = new Product(2, "булка", 45);
        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.remove(2);

        Product[] expected = {product1};
        Product[] atual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, atual);

    }
}
