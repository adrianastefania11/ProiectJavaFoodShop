package com.example.foodshop.service;

import com.example.foodshop.domain.Basket;
import com.example.foodshop.dto.BasketDto;
import com.example.foodshop.exception.BasketNotFoundException;
import com.example.foodshop.mapper.BasketMapper;
import com.example.foodshop.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketService {

    private final BasketRepository basketRepository;

    private final BasketMapper basketMapper;

    @Autowired
    public BasketService(BasketRepository basketRepository, BasketMapper basketMapper) {
        this.basketRepository = basketRepository;
        this.basketMapper = basketMapper;
    }

     public List<BasketDto> getBasketsByCustomer(Long id) {
       List<Basket> baskets = basketRepository.findBasketsByCustomerId(id);
       return baskets.stream().map(o -> basketMapper.mapToDto(o)).collect(Collectors.toList());
    }
    public List<BasketDto> getAllBaskets() {
        List<Basket> baskets = basketRepository.findAll();
        return baskets.stream().map(p -> basketMapper.mapToDto(p)).collect(Collectors.toList());

    }

    public boolean deleteBasket(Long id) {
        boolean exists = basketRepository.existsById(id);

        if (!exists) {
            throw  new BasketNotFoundException("basket with Id " + id + " does not exist");
        }
        else {
            basketRepository.deleteById(id);
            return true;

        }

    }
    @Transactional
    public boolean updateBasket(Long  id, Basket basketUpdate) {
        Basket basket = basketRepository.findBasketById(id);

        if(basket != null)
        {
            if(basketUpdate.getTotal() != null){
                basket.setTotal(basketUpdate.getTotal());
            }

            if(basketUpdate.getCustomer() != null){
                basket.setCustomer(basketUpdate.getCustomer());
            }

            return true;
        }
        else {
            return false;
        }

    }

    public BasketDto createBasket(BasketDto basketDto) {
        Basket basket = basketMapper.mapToEntity(basketDto);
        Basket savedBasket = basketRepository.save(basket);

        return basketMapper.mapToDto(savedBasket);
    }


}
