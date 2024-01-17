package com.example.foodshop.mapper;

import com.example.foodshop.domain.Basket;
import com.example.foodshop.dto.BasketDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BasketMapper {

    @Mapping(target = "total", source = "total")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "customer.id", source = "customer.id")
    @Mapping(target = "customer.lastName", source = "customer.lastName")
    @Mapping(target = "customer.firstName", source = "customer.firstName")
    @Mapping(target = "customer.email", source = "customer.email")
    @Mapping(target = "customer.password", source = "customer.password")
    BasketDto mapToDto(Basket basket);

    @Mapping(target = "total", source = "total")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "customer.id", source = "customer.id")
    @Mapping(target = "customer.lastName", source = "customer.lastName")
    @Mapping(target = "customer.firstName", source = "customer.firstName")
    @Mapping(target = "customer.email", source = "customer.email")
    @Mapping(target = "customer.password", source = "customer.password")
    Basket mapToEntity(BasketDto basket);
}
