package com.orange.book.controller;

import com.orange.book.model.Booking;
import com.orange.book.model.Customer;
import com.orange.book.model.CustomerTable;
import com.orange.book.model.payload.BookDataModel;
import com.orange.book.service.BookingService;
import com.orange.book.service.CustomerService;
import com.orange.book.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private TableService tableService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<String> addBooking(@RequestParam BookDataModel bookDataModel) {

        String tableCode = bookDataModel.getTableCode();
        CustomerTable customerTable = tableService.getTableByCode(tableCode);
        String email = bookDataModel.getEmail();
        Customer customer = customerService.getCustomerByEmail(email);
        LocalDate date = bookDataModel.getBookDate();
        Booking booking = new Booking();
        booking.setUserId(customer.getId());
        booking.setTableId(customerTable.getTableId());
        booking.setDate(date);
        booking.setTime(LocalTime.now());
        if(checkTables(customerTable.getTableId()) && checkDates(LocalTime.now(),date)) {
            bookingService.saveBooking(booking);
//            CustomerTable customerTable =tableService.getTableById(customerTable.getTableId());
            customerTable.setIsAvailable(false);
            tableService.saveTable(customerTable);
        }
        else
            return ResponseEntity.ok("table or time busy !!");
        return ResponseEntity.ok("Added new booking to repo!");

    }

//    @PostMapping("/add")
//    public ResponseEntity<String> addBooking(@RequestParam int userId,
//                                             @RequestParam int tableId,
//                                             @RequestParam LocalDate date,
//                                             @RequestParam LocalTime time) {
//
//        Booking booking = new Booking();
//        booking.setUserId(userId);
//        booking.setTableId(tableId);
//        booking.setDate(date);
//        booking.setTime(time);
//        if(checkTables(tableId) && checkDates(time,date)) {
//            bookingService.saveBooking(booking);
//            CustomerTable customerTable =tableService.getTableById(tableId);
//            tableService.saveTable(customerTable);
//        }
//        else
//            return ResponseEntity.ok("table or time busy !!");
//        return ResponseEntity.ok("Added new booking to repo!");
//    }

    public Boolean checkTables(int tableId){
        if(tableService.getTableById(tableId).getIsAvailable())
            return true;
        return false;
    }

    public Boolean checkDates(LocalTime time,LocalDate date){
        List<Booking> bookingList = bookingService.getAllBooks();
        for(Booking booking:bookingList){
            if(booking.getDate().isEqual(date) && booking.getTime().equals(time))
                return false;
        }
        return true;
    }

    @GetMapping("/test")
    public String testApi(){
        return "booking Api Working Good";
    }

    @GetMapping("/list")
    public List<Booking> getBooks() {
        return bookingService.getAllBooks();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Booking> findBookingById(@PathVariable Integer bookingId) {
        return ResponseEntity.ok(bookingService.getBookById(bookingId));
    }


    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Integer bookingId) {
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.ok("booking deleted successfully");
    }
}
