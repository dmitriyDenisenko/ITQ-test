package com.itq.demo.persistennce.Orders;

import com.itq.demo.api.orders.OrdersRepository;
import com.itq.demo.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class OrdersRepositoryAdapter implements OrdersRepository {
    private final OrdersJpaRepository ordersJpaRepository;

    @Override
    public Page<Order> findAllOrders(int offset, int limit) {
        return ordersJpaRepository.findAll(PageRequest.of(offset, limit));
    }
}
