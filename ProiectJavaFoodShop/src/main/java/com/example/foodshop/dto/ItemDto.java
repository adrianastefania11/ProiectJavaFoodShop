package com.example.foodshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private Long id;

    private String name;

    @Positive
    private Double price;

    private Long quantity;

}
