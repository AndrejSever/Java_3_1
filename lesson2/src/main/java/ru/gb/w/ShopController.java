package ru.gb.w;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ShopController {

    private final ProductRepository productRepository;


    @Lookup
    public Cart getCart() {
        return null;
    }

    public void addProductToCartById(Integer id, Cart cart) {
        productRepository.findById(id).ifPresent(cart::add);
    }

    public void deleteProductToCartById(Integer id, Cart cart) {
        cart.deleteByProductId(id);
    }
}
