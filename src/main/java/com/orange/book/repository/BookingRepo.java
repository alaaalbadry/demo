package com.orange.book.repository;

import com.orange.book.model.Booking;
import com.orange.book.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepo extends CrudRepository<Booking, Integer> {
    @Override
    List<Booking> findAll();
    Optional<Booking> findByBookingId(final int bookingId);

}
