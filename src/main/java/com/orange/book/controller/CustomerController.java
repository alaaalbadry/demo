package com.orange.book.controller;


import com.orange.book.model.Customer;
import com.orange.book.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<String> addCustomer(@RequestParam String first,
                                              @RequestParam String last,
                                              @RequestParam String email,
//                                            @RequestParam String password,
                                              @RequestParam String mobNumber) {

        Customer customer = new Customer();
        customer.setFirstName(first);
        customer.setLastName(last);
        customer.setEmail(email);
        //customer.setPassword(password);
        customer.setMobNumber(mobNumber);
        customerService.saveCustomer(customer);
        return ResponseEntity.ok("Added new customer to repo!");

    }

    @GetMapping("/test")
    public String testApi(){
        return "customer Api Working Good";
    }

    @GetMapping("/list")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Integer id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }


    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("customer deleted successfully");
    }
}
