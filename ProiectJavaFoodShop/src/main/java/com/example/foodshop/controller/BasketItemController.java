package com.example.foodshop.controller;

import com.example.foodshop.domain.BasketItem;
import com.example.foodshop.dto.BasketItemDto;
import com.example.foodshop.service.BasketItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/basketitems")
public class BasketItemController {
    @Autowired
    private BasketItemService basketItemService;

    @GetMapping("/basketItems")
    public ResponseEntity<List<BasketItemDto>> getBasketItemsByBaskets(@RequestParam Long id) {
        return ResponseEntity
                .ok()
                .body(basketItemService.getBasketItemsByBasket(id));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteInvoice(@RequestParam Long id) {
        boolean deleted = basketItemService.deleteBasketItem(id);

        if (deleted) {
            return ResponseEntity.ok().body("Invoice deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Invoice not found or could not be deleted");
        }
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateBasketItem(@RequestParam Long id,
                                                @RequestBody BasketItem basketItem) {
        boolean updated = basketItemService.updateBasketItem(id, basketItem);
        if (updated) {
            return ResponseEntity.ok().body("invoice updated successfully");
        } else {
            return ResponseEntity.status(404).body("invoice not found or could not be updated");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<BasketItemDto> createBasketItem(@RequestBody BasketItemDto basketItemDto) {
        return ResponseEntity
                .ok()
                .body(basketItemService.createBasketItem(basketItemDto));
    }
}
