package com.orange.book.controller;

import com.orange.book.model.Booking;
import com.orange.book.model.CustomerTable;
import com.orange.book.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/table")
public class TableController {
    @Autowired
    private TableService tableService;

    @PostMapping("/add")
    public ResponseEntity<String> addTable(  @RequestParam  String tableCode,
                                              @RequestParam int capacity,
                                              @RequestParam Boolean isAvailable) {

        CustomerTable table = new CustomerTable();
        table.setTableCode(tableCode);
        table.setCapacity(capacity);
        table.setIsAvailable(isAvailable);
        tableService.saveTable(table);
        return ResponseEntity.ok("Added new table to repo!");

    }

    @GetMapping("/test")
    public String testApi(){
        return "table Api Working Good";
    }

    @GetMapping("/list")
    public List<CustomerTable> getTables() {
        return tableService.getAllTables();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CustomerTable> findCustomerById(@PathVariable Integer id) {
        return ResponseEntity.ok(tableService.getTableById(id));
    }

    public Boolean checkTables(int tableId){
        if(tableService.getTableById(tableId).getIsAvailable())
            return true;
        return false;
    }

    @GetMapping("/list/available")
    public List<CustomerTable> getAvailableTables() {
        List<CustomerTable> availableTablesList = new ArrayList<CustomerTable>();
        List<CustomerTable> allList =tableService.getAllTables();
        for(CustomerTable table:allList){
            if(checkTables(table.getTableId())){
                availableTablesList.add(table);
            }
        }
        return availableTablesList;
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<String> deleteTableById(@PathVariable Integer id) {
        tableService.deleteTable(id);
        return ResponseEntity.ok("customer deleted successfully");
    }
}
