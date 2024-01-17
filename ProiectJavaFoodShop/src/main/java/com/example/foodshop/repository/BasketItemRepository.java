package com.example.foodshop.repository;

import com.example.foodshop.domain.BasketItem;
import com.example.foodshop.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketItemRepository extends JpaRepository<BasketItem, Long> {

    List<BasketItem> findOrderItemsByBasketId(Long id);

    void deleteByItemId(Long itemId);


    List<BasketItem> findAll();
    BasketItem save(BasketItem saved);

    BasketItem findBasketItemById(Long id);

}
