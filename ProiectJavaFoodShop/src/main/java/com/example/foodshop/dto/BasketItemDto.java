package com.example.foodshop.dto;

import com.example.foodshop.domain.Basket;
import com.example.foodshop.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketItemDto {

    private Long id;

    private Basket basket;

    private Item item;

    private Long quantity;
}
