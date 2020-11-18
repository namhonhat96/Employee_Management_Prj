package com.namho.book_projc.dao.impl;


import com.namho.book_projc.domain.Book;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book detail = new Book();
        detail.setISBN(resultSet.getInt(1));
        detail.setBook_name(resultSet.getString(2));
        detail.setAuthor(resultSet.getString(3));
        detail.setDate(resultSet.getString(4));
        return detail;
    }
}
