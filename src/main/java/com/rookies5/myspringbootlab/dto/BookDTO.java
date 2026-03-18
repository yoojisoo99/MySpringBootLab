package com.rookies5.myspringbootlab.dto;

import com.rookies5.myspringbootlab.entity.Book;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BookCreateRequest {
        @NotBlank(message = "제목은 필수입니다.")
        private String title;
        @NotBlank(message = "저자는 필수입니다.")
        private String author;
        private String isbn;
        private int price;
        private LocalDate publishDate;

        public Book toEntity() {
            return Book.builder()
                    .title(this.title)
                    .author(this.author)
                    .isbn(this.isbn)
                    .price(this.price)
                    .publishDate(this.publishDate)
                    .build();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BookUpdateRequest {
        private int price;
        private String title;
        private String author;
        private LocalDate publishDate;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BookResponse{
        private Long id;
        private String title;
        private String author;
        private String isbn;
        private int price;
        private LocalDate publishDate;

        public static BookResponse from(Book book) {
            return BookResponse.builder()
                    .id(book.getId())
                    .title(book.getTitle())
                    .author(book.getAuthor())
                    .isbn(book.getIsbn())
                    .price(book.getPrice())
                    .publishDate(book.getPublishDate())
                    .build();
        }
    }
}
