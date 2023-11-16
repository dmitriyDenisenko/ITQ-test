package com.itq.demo.persistennce.OrderDetails;

import com.itq.demo.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepositoryJpa extends JpaRepository<OrderDetail, Long> {
}
