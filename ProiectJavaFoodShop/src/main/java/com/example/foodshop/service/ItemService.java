package com.example.foodshop.service;

import com.example.foodshop.domain.Item;
import com.example.foodshop.dto.ItemDto;
import com.example.foodshop.exception.ItemNotFoundException;
import com.example.foodshop.mapper.ItemMapper;
import com.example.foodshop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BasketItemService basketItemService;

    @Autowired
    private ItemMapper itemMapper;

    public List<ItemDto> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream().map(p -> itemMapper.mapToDto(p)).collect(Collectors.toList());

    }

    public ItemDto getOne(String Name) {
        Optional<Item> item = Optional.ofNullable(itemRepository.findItemByName(Name));
        if (item.isEmpty()) {
            throw new ItemNotFoundException("This item does not exist");
        }
        return itemMapper.mapToDto(item.get());
    }

    public boolean deleteItem(Long id) {
        boolean exists = itemRepository.existsById(id);
        
        if (!exists) {
            throw  new ItemNotFoundException("item with Id " + id + " does not exist");
        }
        else {
            itemRepository.deleteById(id);
            basketItemService.deleteItemReference(id);
            return true;

        }

    }
    @Transactional
    public boolean updateItem(String  name, Item itemUpdate) {
        Item item = itemRepository.findItemByName(name);

        if(item != null)
        {
            if(itemUpdate.getPrice() != null){
                item.setPrice(itemUpdate.getPrice());
            }

            if(itemUpdate.getName() != null){
                item.setName(itemUpdate.getName());
            }

            if(itemUpdate.getQuantity() != null){
                item.setQuantity(itemUpdate.getQuantity());
            }
            return true;
        }
        else {
            return false;
        }

    }



    public ItemDto createItem(ItemDto itemDto) {
        Item item = itemMapper.mapToEntity(itemDto);
        Item savedItem = itemRepository.save(item);

        return itemMapper.mapToDto(savedItem);
    }
}

