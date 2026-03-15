package com.rookies5.myspringbootlab.repository;

import com.rookies5.myspringbootlab.entity.Book;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles("prod")
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    @Rollback(value = false)
    @Disabled
    void testCreateBook() {
        Book book = new Book();
        book.setTitle("JPA 프로그래밍");
        book.setAuthor("박둘리");
        book.setIsbn("9788956746432");
        book.setPrice(35000);
        book.setPublishDate(LocalDate.of(2025,04,30));

        Book savedBook = bookRepository.save(book);
    }

    @Test
    void testFindByIsbn() {
        Optional<Book> optionalBook = bookRepository.findByIsbn("9788956746425");
        if(optionalBook.isPresent()) {
            Book book = optionalBook.get();
            assertThat(book.getIsbn()).isEqualTo("9788956746425");
        }else{
            System.out.println("Book Not Found");
        }
    }

    @Test
    void testFindByAuthor() {
        List<Book> books = bookRepository.findByAuthor("홍길동");
        if(!books.isEmpty()) {
            // get()은 Optional의 메서드이므로, List에서는 get(0) 처럼 인덱스를 지정해야 합니다.
            Book book = books.get(0);
            assertThat(book.getAuthor()).isEqualTo("홍길동");
        }else{
            System.out.println("Book Not Found");
        }
    }

    @Test
    void testUpdateBook() {
        Book book = bookRepository.findByIsbn("9788956746425")
                .orElseThrow(() -> new RuntimeException("Book Not Found"));
        book.setAuthor("홍길동2");
        bookRepository.save(book);
        assertThat(book.getAuthor()).isEqualTo("홍길동2");
    }

    @Test
    @Disabled
    void testDeleteBook() {
        // 1. 해당 ISBN을 가진 책을 조회
        Book book = bookRepository.findByIsbn("9788956746425")
                .orElseThrow(() -> new RuntimeException("Book Not Found"));

        // 2. 조회된 객체를 삭제
        bookRepository.delete(book);

        // 3. 다시 조회했을 때 결과가 비어있는지(Empty) 확인
        Optional<Book> deletedBook = bookRepository.findByIsbn("9788956746425");
        assertThat(deletedBook).isEmpty();
    }
}
