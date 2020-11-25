package com.orange.book.controller;



import com.orange.book.repository.CustomerRepo;
import com.orange.book.model.Customer;
import com.orange.book.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email,
                                        @RequestParam String password) {

      if(customerService.getCustomerByEmailAndPassword(email,password) != null)
            return ResponseEntity.ok("Login Successfully!");

        return ResponseEntity.ok("email or password wrong!");
    }

    @GetMapping("/test")
    public String testApi(){
        return "Login Api Working Good";
    }
//
//    @GetMapping("/list")
//    public List<Customer> getCustomers() {
//        return customerService.getAllCustomers();
//    }
//
//    @GetMapping("/find/{id}")
//    public ResponseEntity<Customer> findCustomerById(@PathVariable Integer id) {
//            return ResponseEntity.ok(customerService.getCustomerById(id));
//    }
//
//
//    @DeleteMapping ("/delete/{id}")
//    public ResponseEntity<String> deleteCustomerById(@PathVariable Integer id) {
//        customerService.deleteCustomer(id);
//        return ResponseEntity.ok("customer deleted successfully");
//    }


}


