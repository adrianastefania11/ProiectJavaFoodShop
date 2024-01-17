package com.example.foodshop.mapper;

import com.example.foodshop.domain.Item;
import com.example.foodshop.dto.ItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "quantity", source = "quantity")
    ItemDto mapToDto(Item item);


    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "id", source = "id")
    Item mapToEntity(ItemDto item);
}
