package com.namho.book_projc.dao;

public interface OnBoardApp_VisaStatusDAO {
    void addVisaStatus(int ID, String visaType,String active,
                   String modificationDate, String createUser);
}
