package com.itq.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_details", schema = "public")
@Data
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    private String productNumber;

    private String productName;

    private int productCount;

    @OneToOne(targetEntity = Order.class)
    @JoinColumn(name = "order_id", nullable = false) // Указываем имя столбца внешнего ключа
    private Order order;
}
