package com.example.springwebdemo.services;

import com.example.springwebdemo.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
