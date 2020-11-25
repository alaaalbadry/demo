package com.orange.book.repository;

import com.orange.book.model.CustomerTable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TableRepo extends CrudRepository<CustomerTable, Integer> {
    @Override
    List<CustomerTable> findAll();
    Optional<CustomerTable> findByTableId(final int tableId);
    Optional<CustomerTable> findByTableCode(final String tableCode);

}