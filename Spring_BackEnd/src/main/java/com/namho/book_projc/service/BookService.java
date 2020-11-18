package com.namho.book_projc.service;

import com.namho.book_projc.domain.Book;

import java.util.List;

public interface BookService {

    void addBook(int IBSN, String name, String author, String date);
    boolean updateBook(int ISBN, String name, String author, String date);
    List<Book> getAllBookInfo();
}
