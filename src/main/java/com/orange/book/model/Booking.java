package com.orange.book.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Booking  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookingId;
    private int userId;
    private LocalDate date;
    private LocalTime time;
    private int tableId;


    public int getTableId() {
        return tableId;
    }


    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getBookingId() {
        return bookingId;
    }


    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }


    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }


    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", userId='" + userId + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", tableId='" + tableId + '\'' +
                '}';
    }
}

