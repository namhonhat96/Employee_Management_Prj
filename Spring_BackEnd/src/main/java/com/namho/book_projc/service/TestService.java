package com.namho.book_projc.service;


import com.namho.book_projc.domain.Test;

import java.util.List;

public interface TestService {

    public void save(Test test);
    List<Test> getAllTestInfo();
}
