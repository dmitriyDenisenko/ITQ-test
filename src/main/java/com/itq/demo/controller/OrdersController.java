package com.itq.demo.controller;


import com.itq.demo.api.orders.FindAllOrdersInbound;
import com.itq.demo.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class OrdersController {
    private final FindAllOrdersInbound findAllOrdersInbound;


    @GetMapping("/orders")
    public Page<Order> getOrders(
            @RequestParam(value = "offset", defaultValue = "0") Integer offset,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        return findAllOrdersInbound.execute(offset, limit);
    }

}
