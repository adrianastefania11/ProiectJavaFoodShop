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
//@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
    private Long id;

    //@Column(name = "creationDate")
    private Date creationDate;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @Column(name = "total_price")
    private Double totalPrice;
}
