//package com.example.foodshop.controller;
//
//import com.example.foodshop.domain.Item;
//import com.example.foodshop.dto.ItemDto;
//import com.example.foodshop.repository.ItemRepository;
//import com.example.foodshop.service.ItemService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.assertj.core.api.BDDAssumptions;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.ResultMatcher;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.assertj.core.api.BDDAssumptions.given;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.when;
//import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ItemControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private ItemRepository itemRepository;
//
//
//
////    @Test
////    public void getItemByNameTest() throws Exception {
////
////        Item item = new Item( Integer.toUnsignedLong(1), "test", 35.0, Integer.toUnsignedLong(200));
////
////        when(itemRepository.findItemByName("test")).thenReturn(item);
////
////        mockMvc.perform(get("/items/name/{Name}", "test"))
////                .andExpect(status().isOk())
////                .andExpect((ResultMatcher) jsonPath("$.name").value("test"))
////                .andExpect((ResultMatcher) jsonPath("$.quantity").value(200))
////                .andExpect((ResultMatcher) jsonPath("$.price").value(35.0));
////
////    }
//
//
//        @Mock
//        private ItemService itemService;
//
//        @InjectMocks
//        private ItemController itemController;
//
//        private ObjectMapper objectMapper = new ObjectMapper();
//
//        @BeforeEach
//        public void setup() {
//            mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
//        }
//
//        @Test
//        public void getAllItems_ShouldReturnItems() throws Exception {
//            // Arrange
//            List<ItemDto> items = Arrays.asList(new ItemDto(), new ItemDto());
//            when(itemService.getAllItems()).thenReturn(items);
//
//            // Act & Assert
//            mockMvc.perform(get("/items/all"))
//                    .andExpect(status().isOk())
//                    .andExpect((ResultMatcher) jsonPath("$").isArray())
//                    .andExpect((ResultMatcher) jsonPath("$.length()").value(items.size()));
//        }
//
//        @Test
//        public void getItemByName_ShouldReturnItem() throws Exception {
//            // Arrange
//            String name = "ItemName";
//            ItemDto item = new ItemDto();
//            when(itemService.getOne(name)).thenReturn(item);
//
//            // Act & Assert
//            mockMvc.perform(get("/items/name/{Name}", name))
//                    .andExpect(status().isOk())
//                    .andExpect((ResultMatcher) jsonPath("$").exists());
//        }
//
//        @Test
//        public void deleteItem_ShouldDeleteItem() throws Exception {
//            // Arrange
//            Long id = 1L;
//            when(itemService.deleteItem(id)).thenReturn(true);
//
//            // Act & Assert
//            mockMvc.perform(delete("/items/delete").param("id", id.toString()))
//                    .andExpect(status().isOk())
//                    .andExpect((ResultMatcher) content().string("Customer deleted successfully"));
//        }
//
//
//        @Test
//        public void updateItem_ShouldUpdateItem() throws Exception {
//            // Arrange
//            String itemName = "ItemName";
//            ItemDto itemDto = new ItemDto();
//            String itemJson = objectMapper.writeValueAsString(itemDto);
//            when(itemService.updateItem(eq(itemName), any(Item.class))).thenReturn(true);
//
//            // Act & Assert
//            mockMvc.perform(put("/items/update")
//                            .param("itemName", itemName)
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(itemJson))
//                    .andExpect(status().isOk())
//                    .andExpect((ResultMatcher) content().string("Item updated successfully"));
//        }
//
//        @Test
//        public void createItem_ShouldCreateItem() throws Exception {
//            // Arrange
//            ItemDto itemDto = new ItemDto();
//            String itemJson = objectMapper.writeValueAsString(itemDto);
//            when(itemService.createItem(any(ItemDto.class))).thenReturn(itemDto);
//
//            // Act & Assert
//            mockMvc.perform((RequestBuilder) post("/items/create")
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .contentType(MediaType.valueOf(itemJson))) // Correct usage of 'content' in request building
//                    .andExpect(status().isOk())
//                    .andExpect((ResultMatcher) jsonPath("$").exists()); // Assertions to validate the response
//        }
//}
//
