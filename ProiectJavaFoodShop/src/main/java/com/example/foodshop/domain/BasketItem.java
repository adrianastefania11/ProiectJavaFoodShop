package com.example.foodshop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "basketItems")
public class BasketItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    private Item item;

    //@Column(name = "quantity")
    private Long quantity;
}
