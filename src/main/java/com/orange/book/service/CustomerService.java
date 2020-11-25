package com.orange.book.service;

import com.orange.book.model.Customer;
import com.orange.book.repository.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer getCustomerById(final int customerId) {
        Optional<Customer> customerOptional = customerRepo.findById(customerId);

        Customer customer = customerOptional.orElse(new Customer());
        return customer;
    }

    public Customer getCustomerByName(final String lastName) {
        Optional<Customer> customerOptional = customerRepo.findByLastName(lastName);
        Customer customer = customerOptional.orElse(new Customer());
        return customer;
    }

    public Customer getCustomerByEmailAndPassword(final String email,final String password) {
        Optional<Customer> customerOptional = customerRepo.findCustomerByEmailAndPassword(email,password);
        Customer customer = customerOptional.orElse(new Customer());
        return customer;
    }

    public Customer getCustomerByEmail(final String email) {
        Optional<Customer> customerOptional = customerRepo.findCustomerByEmail(email);
        Customer customer = customerOptional.orElse(new Customer());
        return customer;
    }
    public void saveCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public  void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }


}


