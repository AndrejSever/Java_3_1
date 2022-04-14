package ru.gb.w;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope("prototype")
public class Cart {
    private final Map<Product, Integer> products = new HashMap<>();

    public void add(Product product) {
        products.put(product, products.getOrDefault(product, 0) + 1);
    }

    public void deleteByProductId(Integer id) {
        Product product = Product.builder().id(id).build();
        if (products.getOrDefault(product, 0) <= 1) {
            if (products.remove(product) == null) {
                System.out.println(id + " Продукта нет в корзине ");
            }
        } else {
            products.put(product, products.get(product) - 1);
        }
    }

    public void showList() {
        System.out.println(products);
    }
}
