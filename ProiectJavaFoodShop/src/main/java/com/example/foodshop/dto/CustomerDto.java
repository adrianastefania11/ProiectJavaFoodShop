package com.example.foodshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Long id;

    private String lastName;

    private String firstName;

    private String email;

    private String password;
}
