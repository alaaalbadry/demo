package com.orange.book.repository;

import com.orange.book.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  CustomerRepo  extends CrudRepository<Customer, Integer> {
    @Override
    List<Customer> findAll();
    Optional<Customer>  findByLastName(final String lastName);
    Optional<Customer>  findCustomerByEmailAndPassword(final String email,final String password);
    Optional<Customer>  findCustomerByEmail(final String email);


}

