package com.example.foodshop.dto;

import com.example.foodshop.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketDto {

    private Long id;

    private Double total;

    private Customer customer;
}
