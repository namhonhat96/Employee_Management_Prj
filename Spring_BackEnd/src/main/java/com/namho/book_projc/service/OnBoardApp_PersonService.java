package com.namho.book_projc.service;

public interface OnBoardApp_PersonService {
    void addPerson(int ID, String firstname, String lastname, String middlename,
                   String email, String cellphone, String alternatephone, String gender, int SSN, String DOB );
}
