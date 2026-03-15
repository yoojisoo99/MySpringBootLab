package com.rookies5.myspringbootlab.controller;

import com.rookies5.myspringbootlab.entity.Book;
import com.rookies5.myspringbootlab.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookRestController {
    private final BookRepository bookRepository;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    //모든 도서
    @GetMapping
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    //ID 특정 도서 조회
    @GetMapping("/{id}")
    public Book findBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    //ISBN으로 도서 조회
    @GetMapping("/isbn/{isbn}")
    public Book findBookByIsbn(@PathVariable String isbn) {
        return bookRepository.findAll().stream()
                .filter(book -> isbn.equals(book.getIsbn()))
                .findFirst()
                .orElse(null);
    }

    //도서 정보 수정
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    //도서 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return ResponseEntity.ok("Id = " + id +"User가 삭제 되었습니다. ");
    }
}
