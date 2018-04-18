package com.ram.bootstrap;

import com.ram.models.Author;
import com.ram.models.Book;
import com.ram.models.Publisher;
import com.ram.repository.AuthorRepository;
import com.ram.repository.BookRepository;
import com.ram.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author rams0516
 *         Date: 4/18/2018
 *         Time: 12:56 PM
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(BookRepository bookRepository, AuthorRepository authorRepository,
                        PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        initData();
    }

    private void initData() {

        Author ram = new Author("Ram", "Shandilya");
        Publisher publisherOne = new Publisher("First Publisher", "First Address");
        Book one = new Book("Book One", "1234", publisherOne);
        ram.getBooks().add(one);
        one.getAuthors().add(ram);

        publisherRepository.save(publisherOne);
        authorRepository.save(ram);
        bookRepository.save(one);

        Author sam = new Author("Sam", "Rai");
        Publisher publisherTwo = new Publisher("Sencod Publisher", "Second Address");
        Book two = new Book("Book Two", "1232", publisherTwo);
        sam.getBooks().add(two);
        two.getAuthors().add(sam);

        publisherRepository.save(publisherTwo);
        authorRepository.save(sam);
        bookRepository.save(two);
    }
}