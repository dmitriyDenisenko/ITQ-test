package com.itq.demo.impl.orders;


import com.itq.demo.api.orders.FindAllOrdersInbound;
import com.itq.demo.api.orders.OrdersRepository;
import com.itq.demo.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FindAllOrdersUseCase implements FindAllOrdersInbound {
    private final OrdersRepository ordersRepository;

    @Override
    public Page<Order> execute(int offset, int limit){
        return ordersRepository.findAllOrders(offset,limit);
    }
}
