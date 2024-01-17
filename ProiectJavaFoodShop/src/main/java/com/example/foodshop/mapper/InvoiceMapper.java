package com.example.foodshop.mapper;

import com.example.foodshop.domain.Invoice;
import com.example.foodshop.dto.InvoiceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "creationDate", source = "creationDate")
    @Mapping(target = "totalPrice", source = "basket.total")
    @Mapping(target = "basketId", source = "basket.id")
    InvoiceDto mapToDto(Invoice invoice);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "basket.id", source = "basketId")
    @Mapping(target = "creationDate", source = "creationDate")
    @Mapping(target = "basket.total", source = "totalPrice")
    Invoice mapToEntity(InvoiceDto invoice);
}
