package com.namho.book_projc.dao;

import com.namho.book_projc.domain.Test;

import java.util.List;

public interface TestDAO {
    public void save(Test test);
    List<Test> getTestInfo();
}
