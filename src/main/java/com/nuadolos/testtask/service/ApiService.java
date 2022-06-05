package com.nuadolos.testtask.service;

import com.nuadolos.testtask.model.Account;
import com.nuadolos.testtask.model.Deal;
import com.nuadolos.testtask.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface ApiService {
    Account getData();
    List<Product> getProducts();
    boolean makeDeal(@RequestBody Deal deal);
}
