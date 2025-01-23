package com.cintest.orders.model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "oUnits")
    private Integer oUnits;

    @Column(name = "oBonus")
    private Integer oBonus;

    @Column(name = "oPromo")
    private Integer oPromo;

    @Column(name = "oTotalPrice")
    private BigDecimal oTotalPrice;

    @ManyToOne
    @JoinColumn(name = "producti_id",nullable = false)
    private Product product;
}
