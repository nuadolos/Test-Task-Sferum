package com.nuadolos.testtask.model;

import java.util.List;

public class Account {

    private double balance;
    private List<Book> books;


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Book> getBooks() {
        return  books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
