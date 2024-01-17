package com.example.foodshop.mapper;

import com.example.foodshop.domain.BasketItem;
import com.example.foodshop.dto.BasketItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BasketItemMapper {
    @Mapping(target = "basket.total", source = "basket.total")
    @Mapping(target = "basket.id", source = "basket.id")
    @Mapping(target = "item.id", source = "item.id")
    @Mapping(target = "item.name", source = "item.name")
    @Mapping(target = "item.price", source = "item.price")
    @Mapping(target = "item.quantity", source = "item.quantity")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "quantity", source = "quantity")
    BasketItemDto mapToDto(BasketItem basketItem);

    @Mapping(target = "basket.total", source = "basket.total")
    @Mapping(target = "basket.id", source = "basket.id")
    @Mapping(target = "item.id", source = "item.id")
    @Mapping(target = "item.name", source = "item.name")
    @Mapping(target = "item.price", source = "item.price")
    @Mapping(target = "item.quantity", source = "item.quantity")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "quantity", source = "quantity")
    BasketItem mapToEntity(BasketItemDto basketItem);
}
