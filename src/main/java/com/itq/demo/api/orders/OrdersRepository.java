package com.itq.demo.api.orders;


import com.itq.demo.model.Order;
import org.springframework.data.domain.Page;

public interface OrdersRepository {
    public Page<Order> findAllOrders(int offset, int limit);
}
