package com.example.springwebdemo.services;

import com.example.springwebdemo.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
