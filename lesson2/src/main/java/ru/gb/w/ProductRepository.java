package ru.gb.w;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("productRepository")
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();
    @PostConstruct
    public void init() {
        products.add(new Product(1, "Kortoshka", 45));
        products.add(new Product(2, "Markovka", 35));
        products.add(new Product(3, "Look", 20));
        products.add(new Product(4, "Chesnok", 27));
        products.add(new Product(5, "Petrushka", 23));

    }
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    public Optional<Product> findById(Integer id) {
        if (id < (products.size()) && id >= 0) {
            return  Optional.of(products.get(id));
        } else {
            return Optional.empty();
        }
    }
}
