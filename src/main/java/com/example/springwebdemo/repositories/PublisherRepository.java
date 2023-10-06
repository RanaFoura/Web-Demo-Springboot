package com.example.springwebdemo.repositories;

import com.example.springwebdemo.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
