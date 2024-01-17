package com.example.foodshop.repository;

import com.example.foodshop.domain.Basket;
import com.example.foodshop.domain.Invoice;
import com.example.foodshop.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {


    List<Basket> findBasketsByCustomerId(Long id);
    List<Basket> findAll();
    Basket findBasketById(Long is);
    Basket save(Basket saved);


}
