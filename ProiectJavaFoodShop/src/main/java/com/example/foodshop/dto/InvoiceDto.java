package com.example.foodshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    private Long id;

    private Date creationDate;

    private Double totalPrice;

    private Long basketId;

}
