package ru.gb.w;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HmConfig.class);

       for (int i = 0; i < 5; i++) {
           Buyer buyer = context.getBean(Buyer.class);
           buyer.purchase();
           buyer.showCart();
       }
    }
}
