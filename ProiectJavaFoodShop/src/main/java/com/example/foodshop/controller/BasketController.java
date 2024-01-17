package com.example.foodshop.controller;

import com.example.foodshop.domain.Basket;
import com.example.foodshop.dto.BasketDto;
import com.example.foodshop.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baskets")
public class BasketController {

    @Autowired
    private BasketService basketService;

   @GetMapping("/basketbycustomer")
   public ResponseEntity<List<BasketDto>> getBasketsByCustomer(@RequestParam Long id) {
      return ResponseEntity
               .ok()
               .body(basketService.getBasketsByCustomer(id));
   }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBasket(@RequestParam Long id) {
        boolean deleted = basketService.deleteBasket(id);

        if (deleted) {
            return ResponseEntity.ok().body("Basket deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Basket not found or could not be deleted");
        }
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateBasket(@RequestParam Long id,
                                                @RequestBody Basket basket) {
        boolean updated = basketService.updateBasket(id, basket);
        if (updated) {
            return ResponseEntity.ok().body("basket updated successfully");
        } else {
            return ResponseEntity.status(404).body("basket not found or could not be updated");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<BasketDto> createBasket(@RequestBody BasketDto basketDto) {
        return ResponseEntity
                .ok()
                .body(basketService.createBasket(basketDto));
    }
}
