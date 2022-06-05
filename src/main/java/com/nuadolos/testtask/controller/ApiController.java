package com.nuadolos.testtask.controller;

import com.nuadolos.testtask.model.Account;
import com.nuadolos.testtask.model.Deal;
import com.nuadolos.testtask.model.Product;
import com.nuadolos.testtask.service.ApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private final ApiService accountService;

    public ApiController(ApiService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/account")
    public ResponseEntity<Account> getAccount() {
        final Account account = accountService.getData();

        return  account != null
                ? new ResponseEntity<>(account, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/market")
    public ResponseEntity<List<Product>> getProducts() {
        final List<Product> products = accountService.getProducts();

        return  products != null
                ? new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/market/deal")
    public ResponseEntity<List<Product>> deal(@RequestBody Deal deal) {
        final boolean result = accountService.makeDeal(deal);

        return  result
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
