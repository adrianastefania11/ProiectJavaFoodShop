package com.example.foodshop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "baskets")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
    private Long id;

    //@Column(name = "total")
    private Double total;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
