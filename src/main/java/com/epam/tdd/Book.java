package com.epam.tdd;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Book {
    private String isbn;
    private String title;
    private String author;
}
