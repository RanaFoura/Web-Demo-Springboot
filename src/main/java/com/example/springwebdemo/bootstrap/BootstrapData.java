package com.example.springwebdemo.bootstrap;

import com.example.springwebdemo.domain.Author;
import com.example.springwebdemo.domain.Book;
import com.example.springwebdemo.domain.Publisher;
import com.example.springwebdemo.repositories.AuthorRepository;
import com.example.springwebdemo.repositories.BookRepository;
import com.example.springwebdemo.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Authors
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Jhonson");

        // Books

        Book ddd = new Book();
        ddd.setIsbn("123456");
        ddd.setTitle("Domain Driven Design");

        Book noEJB = new Book();
        noEJB.setIsbn("7891011");
        noEJB.setTitle("noEJB");

        // publisher

        Publisher me = new Publisher();
        me.setName("Middle East");
        me.setAddress("Jordan, Amman, Rainbow street");
        me.setCity("Amman");
        me.setZipCode("25472");
        me.setState("Published");

        Publisher timez = new Publisher();
        timez.setName("Timez");
        timez.setAddress("Jordan, Zarqa, 16 street");
        timez.setCity("Zarqa");
        timez.setZipCode("32425");
        timez.setState("Published");

        // set publisher to book (before)
//        ddd.setPublisher(me);
//        noEJB.setPublisher(timez);



        // saverecord to database


        Author ericsaved =authorRepository.save(eric);
        Publisher mesaved = publisherRepository.save(me);
        Book dddsaved= bookRepository.save(ddd);

        Author rodsaved =authorRepository.save(rod);
        Publisher timezsaved = publisherRepository.save(timez);
        Book noEJBsaved= bookRepository.save(noEJB);

// set publisher to book ( here we make update after create so we use EntityRepository.save(..) )
        dddsaved.setPublisher(mesaved);
        noEJBsaved.setPublisher(timezsaved);


        // add book to author_book

        ericsaved.getBooks().add(ddd);
        rodsaved.getBooks().add(noEJB);
        // we have to do the other part of relationship
        dddsaved.getAuthors().add(eric);
        noEJBsaved.getAuthors().add(rod);


        // add book to publisher
            me.getBooks().add(ddd);
            timez.getBooks().add(noEJB);

        authorRepository.save(ericsaved);
        authorRepository.save(rodsaved);
        bookRepository.save(dddsaved);
        bookRepository.save(noEJBsaved);


        System.out.println("In Bootstrap");
        System.out.println("Author Count: "+ authorRepository.count());
        System.out.println("Book Count: "+ bookRepository.count());
        System.out.println("Publisher Count: "+ publisherRepository.count());
        System.out.println();


    }
}
