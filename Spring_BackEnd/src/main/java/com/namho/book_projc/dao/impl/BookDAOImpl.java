package com.namho.book_projc.dao.impl;

import com.namho.book_projc.config.HibernateConfigUtil;
import com.namho.book_projc.dao.BookDAO;
import com.namho.book_projc.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Repository
public class BookDAOImpl implements BookDAO {

    @Override
    public void addBook(int ISBN, String name, String author, String date) {
        Session session = HibernateConfigUtil.openSession();
        Transaction tx = null;
        try {
            Random rand = new Random();
            tx = session.beginTransaction();
            Book book = new Book(ISBN,name, author, date);
            session.save(book);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Book> getBookInfo() {
        Session session = HibernateConfigUtil.openSession();
        List<Book> results = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            results = session.createQuery("FROM Book").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    @Override
    public boolean updateBook(int ISBN, String name, String author, String date){
        Session session = HibernateConfigUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Book book = (Book)session.get(Book.class, ISBN);
            book.setISBN(ISBN);
            book.setBook_name(name);
            book.setAuthor(author);
            book.setDate(date);
            session.update(book);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }
}
