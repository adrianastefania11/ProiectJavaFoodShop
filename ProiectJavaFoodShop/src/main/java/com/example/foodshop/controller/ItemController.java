package com.example.foodshop.controller;

import com.example.foodshop.domain.Item;
import com.example.foodshop.dto.ItemDto;
import com.example.foodshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/all")
    public ResponseEntity<List<ItemDto>> getAllItems() {
        return ResponseEntity
                .ok()
                .body(itemService.getAllItems());
    }

    @GetMapping("/name/{Name}")
    public ResponseEntity<ItemDto> getItemByName(@PathVariable String Name) {
        return ResponseEntity
                .ok()
                .body(itemService.getOne(Name));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteItem(@RequestParam Long id) {
        boolean deleted = itemService.deleteItem(id);

        if (deleted) {
            return ResponseEntity.ok().body("Customer deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Customer not found or could not be deleted");
        }
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateItem(@RequestParam String itemName,
                                                 @RequestBody Item item) {
        boolean updated = itemService.updateItem(itemName, item);
        if (updated) {
            return ResponseEntity.ok().body("Item updated successfully");
        } else {
            return ResponseEntity.status(404).body("Item not found or could not be updated");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto) {
        return ResponseEntity
                .ok()
                .body(itemService.createItem(itemDto));
    }
}
