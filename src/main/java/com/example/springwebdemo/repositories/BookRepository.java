package com.example.springwebdemo.repositories;

import com.example.springwebdemo.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
