package com.ortega.springguru.bootstrap;

import com.ortega.springguru.domain.Author;
import com.ortega.springguru.domain.Book;
import com.ortega.springguru.domain.Publisher;
import com.ortega.springguru.repositories.AuthorRepository;
import com.ortega.springguru.repositories.BookRepository;
import com.ortega.springguru.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisherRepository.save(publisher);

        System.out.println("Publisher count: "+ publisherRepository.count());

        Author erick = new Author("Erick","Evans");
        Book book = new Book("Domaind Drive Design", "123123");
        erick.getBooks().add(book);
        book.getAuthors().add(erick);
        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(erick);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "1245263");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: "+ bookRepository.count());
        System.out.println("Publisher Number of Books: "+ publisher.getBooks().size());
    }
}
