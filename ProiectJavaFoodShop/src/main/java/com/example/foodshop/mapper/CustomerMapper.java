package com.example.foodshop.mapper;

import com.example.foodshop.domain.Customer;
import com.example.foodshop.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "id", source = "id")
    CustomerDto mapToDto(Customer user);

    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "id", source = "id")
    Customer mapToEntity(CustomerDto user);
}
