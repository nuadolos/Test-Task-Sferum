package com.nuadolos.testtask.service;

import com.nuadolos.testtask.model.Account;
import com.nuadolos.testtask.model.Book;
import com.nuadolos.testtask.model.Deal;
import com.nuadolos.testtask.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private static final Account ACCOUNT = new Account();
    private static final List<Product> PRODUCTS = new ArrayList<>();

    public ApiServiceImpl() {
        List<Book> books = new ArrayList<>();

        Book testBook1 = new Book();
        testBook1.setName("Совершенный код");
        testBook1.setAuthor("Стив Макконелл");
        books.add(testBook1);

        Book testBook2 = new Book();
        testBook2.setName("Философия Java");
        testBook2.setAuthor("Брюс Эккель");
        books.add(testBook2);

        Book testBook3 = new Book();
        testBook3.setName("Философия Java");
        testBook3.setAuthor("Брюс Эккель");
        books.add(testBook3);

        ACCOUNT.setBalance(20000);
        ACCOUNT.setBooks(books);

        Book prBook1 = new Book();
        prBook1.setName("Философия Java");
        prBook1.setAuthor("Брюс Эккель");

        Book prBook2 = new Book();
        prBook2.setName("Думай медленно... Решай быстро");
        prBook2.setAuthor("Даниэль Канеман");

        Product pr1 = new Product();
        pr1.setId(0);
        pr1.setBook(prBook1);
        pr1.setPrice(100);
        pr1.setAmount(3);
        PRODUCTS.add(pr1);

        Product pr2 = new Product();
        pr2.setId(1);
        pr2.setBook(prBook2);
        pr2.setPrice(70);
        pr2.setAmount(2);
        PRODUCTS.add(pr2);
    }

    @Override
    public Account getData() {
        return ACCOUNT;
    }

    @Override
    public List<Product> getProducts() {
        return PRODUCTS;
    }

    @Override
    public boolean makeDeal(Deal deal) {

        Product product = null;
        boolean isProduct = false;
        boolean inAbundance = false;
        boolean isSuffice = false;

        for (Product pr : PRODUCTS) {
            if (pr.getId() == deal.getId()) {
                isProduct = true;
                product = pr;
            }
        }

        if (!isProduct)
            return false;

        if (product.getAmount() < deal.getAmount()) {
            return false;
        }

        if (ACCOUNT.getBalance() < (deal.getAmount() * product.getPrice())) {
            return false;
        }

        return true;
    }
}
