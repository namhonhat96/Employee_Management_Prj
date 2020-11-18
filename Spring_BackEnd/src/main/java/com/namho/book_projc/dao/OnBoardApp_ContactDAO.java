package com.namho.book_projc.dao;

public interface OnBoardApp_ContactDAO {
    void addContact(int ID, int personID, String relationship, String isReference, String isEmergency);
}
