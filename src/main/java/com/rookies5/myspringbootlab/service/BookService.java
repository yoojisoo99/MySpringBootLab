package com.rookies5.myspringbootlab.service;

import com.rookies5.myspringbootlab.dto.BookDTO;
import com.rookies5.myspringbootlab.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public interface BookService {

    List<BookDTO.BookResponse> getAllBooks();

    BookDTO.BookResponse getBookById(Long id);

    BookDTO.BookResponse getBookByIsbn(String isbn);

    BookDTO.BookResponse getBookByAuthor(String author);

    BookDTO.BookResponse createBook(BookDTO.BookCreateRequest request);

    BookDTO.BookResponse updateBook(Long id, BookDTO.BookUpdateRequest request);

    void deleteBook(Long id);

}