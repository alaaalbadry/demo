package com.orange.book.service;

import com.orange.book.model.CustomerTable;
import com.orange.book.repository.TableRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TableService {

    private TableRepo tableRepo;

    public TableService(TableRepo tableRepo) {
        this.tableRepo = tableRepo;
    }

    public List<CustomerTable> getAllTables() {
        return tableRepo.findAll();
    }

    public CustomerTable getTableById(final int tableId) {
        Optional<CustomerTable> tableOptional = tableRepo.findById(tableId);
        CustomerTable table = tableOptional.orElse(new CustomerTable());
        return table;
    }

    public CustomerTable getTableByCode(final String tableCode) {
        Optional<CustomerTable> tableOptional = tableRepo.findByTableCode(tableCode);
        CustomerTable table = tableOptional.orElse(new CustomerTable());
        return table;
    }
    public void saveTable(CustomerTable table) {
        tableRepo.save(table);
    }
    public  void deleteTable(int id) {
        tableRepo.deleteById(id);
    }
}
