package com.example.foodshop.service;

import com.example.foodshop.domain.Item;
import com.example.foodshop.dto.ItemDto;
import com.example.foodshop.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTest {
    @MockBean
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    @Test
    public void noItemsReturnedTest() {
        given(itemRepository.findAll()).willReturn(Collections.emptyList());

        List<ItemDto> items = itemService.getAllItems();

        assertTrue(items.isEmpty());
    }

    @Test
    public void getItemTest() {

        Item item = new Item();
        String name = "ItemName";
        Long itemId = 1L; // Assume an ID for the item
        item.setId(itemId);
        item.setName(name);
        item.setPrice(10.00);
        item.setQuantity(5L);
        itemRepository.save(item);
        List<Item> shopList = Collections.singletonList(item);

        when(itemRepository.findAll()).thenReturn(shopList);

        List<ItemDto> result = itemService.getAllItems();

        // Then
        assertEquals("Should not be empty", result.isEmpty(), false);
        assertEquals(String.valueOf(result.size()), 1, "Should have one element");
    }
    @Test
    public void deleteItemTest() {

        Long itemToDeleteId = 1L;

        when(itemRepository.existsById(itemToDeleteId)).thenReturn(true);

        Boolean result = itemService.deleteItem(itemToDeleteId);

        assertEquals("Should be equals", result, true);
    }
    @Test
    public void updateItemTest() {

//        Item item = new Item();
//        String itemToUpdateName =  "ananas";
//
//        when(itemRepository.findItemByName(itemToUpdateName));
//
//        Boolean result = itemService.updateItem(itemToUpdateName, item);
//
//        assertEquals("Should be equals", result, true);

        String name = "ItemName";
        Long itemId = 1L; // Assume an ID for the item
        Item item = new Item(); // Existing item
        item.setId(itemId);
        item.setName(name);
        item.setPrice(10.00);
        item.setQuantity(5L);
        itemRepository.save(item);

        Item itemUpdate = new Item(); // New updates
        itemUpdate.setName("UpdatedName");
        itemUpdate.setPrice(12.00);
        itemUpdate.setQuantity(7L);

        when(itemRepository.findItemByName(name)).thenReturn(item);
        when(itemRepository.save(any(Item.class))).thenAnswer(i -> i.getArguments()[0]); // Mock save to return the item

        // Act
        boolean result = itemService.updateItem(name, itemUpdate);

        // Assert
        assertTrue(result);
        verify(itemRepository).save(item); // Verify save was called
        assertEquals("UpdatedName", item.getName()); // Verify name was updated
        assertEquals(Double.valueOf(12.00), item.getPrice()); // Verify price was updated
        assertEquals(Integer.valueOf(7), item.getQuantity()); // Verify quantity was updated
    }
    @Test
    public void noItemsAreFoundTest() {
        List<Item> items = Arrays.asList(new Item());

        given(itemRepository.findAll()).willReturn(items);

        List<ItemDto> res = itemService.getAllItems();

        assertEquals(1, res.size());
    }



}

