package com.itq.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.time.LocalDate;

@Entity
@Table(name = "orders", schema = "public")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column
    private String customerName;

    private String customerAddress;

    private int totalCount;

    private LocalDate date;
}
