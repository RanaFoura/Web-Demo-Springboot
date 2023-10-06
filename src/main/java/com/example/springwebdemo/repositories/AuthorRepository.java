package com.example.springwebdemo.repositories;

import com.example.springwebdemo.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
