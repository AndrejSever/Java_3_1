package ru.gb.servlet;

import ru.gb.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = List.of(
                new Product(1, "картофель", 25),
                new Product(2, "Лук", 15),
                new Product(3, "Помидоры", 20),
                new Product(4, "Апельсины", 80),
                new Product(5, "Мандарины", 90),
                new Product(6, "Лимоны", 26),
                new Product(7, "Бананы", 70),
                new Product(8, "Вишня", 31),
                new Product(9, "Клубника", 150),
                new Product(10, "Малина", 120)
        );
        req.setAttribute("product", products);
        getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
    }

}
