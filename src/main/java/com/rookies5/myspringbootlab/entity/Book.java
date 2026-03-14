package com.rookies5.myspringbootlab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="books")
@Getter
@Setter
public class Book {
    @Id
    private Long id;

    private String title;

    private String author;

    private String isbn;

    private int price;

    private LocalDate publishDate;
}
