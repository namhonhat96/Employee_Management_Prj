package com.namho.book_projc.service.impl;

import com.namho.book_projc.dao.BookDAO;
import com.namho.book_projc.domain.Book;
import com.namho.book_projc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    @Autowired
    public void setBookDAO(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    @Override
    public void addBook(int IBSN, String name, String author, String date){
        bookDAO.addBook(IBSN,name,author,date);
    }

    @Override
    public boolean updateBook(int ISBN, String name, String author, String date) {
        return bookDAO.updateBook(ISBN,name,author,date);
    }

    @Override
    public List<Book> getAllBookInfo() {
        List<Book> bookList = bookDAO.getBookInfo();
        return bookList;
    }
}
