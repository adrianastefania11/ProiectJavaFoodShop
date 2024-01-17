package com.example.foodshop.controller;


import com.example.foodshop.domain.Customer;
import com.example.foodshop.dto.BasketDto;
import com.example.foodshop.dto.CustomerDto;
import com.example.foodshop.service.BasketService;
import com.example.foodshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private BasketService basketService;

    @GetMapping("/get")
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.ok().body(customerService.getCustomers());
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCustomer(@RequestParam Long customerId) {
        boolean deleted = customerService.deleteCustomer(customerId);

        if (deleted) {
            return ResponseEntity.ok().body("Customer deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Customer not found or could not be deleted");
        }
    }   
    @PutMapping("/update")
    public ResponseEntity<String> updateCustomer(@RequestParam Long customerId,
                                               @RequestBody Customer customer){
        boolean updated = customerService.updateCustomer(customerId, customer);
        if (updated) {
            return ResponseEntity.ok().body("Customer updated successfully");
        } else {
            return ResponseEntity.status(404).body("Customer not found or could not be updated");
        }
    }
    @PostMapping("/create")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity
                .ok()
                .body(customerService.createCustomer(customerDto));
    }

    @GetMapping("/getCustomertBaskets")
    public ResponseEntity<List<BasketDto>> getBasketsByCustomer(@RequestParam Long customerId){
        return ResponseEntity.ok().body(basketService.getBasketsByCustomer(customerId));
    }

}
