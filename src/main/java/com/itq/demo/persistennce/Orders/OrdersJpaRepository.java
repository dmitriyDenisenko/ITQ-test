package com.itq.demo.persistennce.Orders;

import com.itq.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersJpaRepository extends JpaRepository<Order, Long> {
}
