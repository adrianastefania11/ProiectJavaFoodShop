package com.example.foodshop.service;

import com.example.foodshop.domain.BasketItem;
import com.example.foodshop.domain.BasketItem;
import com.example.foodshop.dto.BasketItemDto;
import com.example.foodshop.exception.BasketNotFoundException;
import com.example.foodshop.mapper.BasketItemMapper;
import com.example.foodshop.repository.BasketItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketItemService {
    @Autowired
    private BasketItemRepository basketItemRepository;

    @Autowired
    private BasketItemMapper basketItemMapper;

    public List<BasketItemDto> getBasketItemsByBasket(Long id) {
        List<BasketItem> basketItems = basketItemRepository.findOrderItemsByBasketId(id);
        return basketItems.stream().map(o -> basketItemMapper.mapToDto(o)).collect(Collectors.toList());

    }

    @Transactional
    public void deleteItemReference(Long id) {
       basketItemRepository.deleteByItemId(id);
    }

    public boolean deleteBasketItem(Long id) {
        boolean exists = basketItemRepository.existsById(id);

        if (!exists) {
            throw  new BasketNotFoundException("basketItem with Id " + id + " does not exist");
        }
        else {
            basketItemRepository.deleteById(id);
            return true;

        }

    }
    @Transactional
    public boolean updateBasketItem(Long  id, BasketItem basketItemUpdate) {
        BasketItem basketItem = basketItemRepository.findBasketItemById(id);

        if(basketItem != null)
        {
            if(basketItemUpdate.getBasket() != null){
                basketItem.setBasket(basketItemUpdate.getBasket());
            }

            if(basketItemUpdate.getItem() != null){
                basketItem.setItem(basketItemUpdate.getItem());
            }

            if(basketItemUpdate.getQuantity() != null){
                basketItem.setQuantity(basketItemUpdate.getQuantity());
            }
            return true;
        }
        else {
            return false;
        }

    }
    
    public BasketItemDto createBasketItem(BasketItemDto basketItemDto) {
        BasketItem basketItem = basketItemMapper.mapToEntity(basketItemDto);
        BasketItem savedBasketItem = basketItemRepository.save(basketItem);

        return basketItemMapper.mapToDto(savedBasketItem);
    }

}
