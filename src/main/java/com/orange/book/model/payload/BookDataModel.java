package com.orange.book.model.payload;

import java.time.LocalDate;

public class BookDataModel {

    private String tableCode;
    private String email;
    private LocalDate bookDate;

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBookDate() {
        return bookDate;
    }

    public void setBookDate(LocalDate bookDate) {
        this.bookDate = bookDate;
    }

    @Override
    public String toString() {
        return "BookDataModel{" +
                "tableCode='" + tableCode + '\'' +
                ", email='" + email + '\'' +
                ", bookDate=" + bookDate +
                '}';
    }
}
