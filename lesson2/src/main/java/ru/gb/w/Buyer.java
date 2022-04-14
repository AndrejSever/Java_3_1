package ru.gb.w;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@RequiredArgsConstructor
@Component
@Scope("prototype")
public class Buyer {
    private final ShopController shopController;

    public Integer productsNumber;
    private Cart cart;

    Random r = new Random();

    @PostConstruct
    public void init() {

        productsNumber = r.nextInt(9) + 2;
        cart = shopController.getCart();
    }

    public void purchase() {
        System.out.println("Покупатель хочет купить " + productsNumber + " продуктов");
        int i = 0;
        while (i < productsNumber) {
            shopController.addProductToCartById(r.nextInt(5), cart);
            i++;
        }
        int getOut = r.nextInt(5);
        System.out.println("Покупатель хочет убрать продукт с id: " + getOut);
        shopController.deleteProductToCartById(getOut, cart);

    }

    public void showCart() {
        System.out.println("Покупатель купил: ");
        cart.showList();
        System.out.println("-----------------------------");
    }
}
