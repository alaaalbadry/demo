package com.orange.book.service;

import com.orange.book.model.Booking;
import com.orange.book.repository.BookingRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class BookingService {

    private BookingRepo bookingRepo;

    public BookingService(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public List<Booking> getAllBooks() {
        return bookingRepo.findAll();
    }

    public Booking getBookById(final int bookingId) {
        Optional<Booking> bookingOptional = bookingRepo.findById(bookingId);
        Booking booking = bookingOptional.orElse(new Booking());
        return booking;
    }

    public void saveBooking(Booking booking) {
        bookingRepo.save(booking);
    }

    public void deleteBooking(int id) {
        bookingRepo.deleteById(id);
    }
}