package com.namho.book_projc.dao;

import com.namho.book_projc.domain.Book;

import java.util.List;

public interface BookDAO {
    void addBook(int ISBN, String name, String author, String date);
    List<Book> getBookInfo();
    boolean updateBook(int ISBN, String name, String author, String date);

}
