package com.rookies5.myspringbootlab.repository;

import com.rookies5.myspringbootlab.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    void testCreateBook() {
        Book book = new Book();
        book.setTitle("스프링 부트 입문");
        book.setAuthor("홍길동");
        book.setIsbn("9788956746425");
        book.setPrice(30000);
        book.setPublishDate(LocalDate.ofEpochDay(2025-05-07));

        Book savedBook = bookRepository.save(book);
    }

    @Test
    void testFindByIsbn() {

    }

    @Test
    void testFindByAuthor() {
    }

    @Test
    void testUpdateBook() {
    }

    @Test
    void testDeleteBook() {
    }
}
