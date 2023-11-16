package com.itq.demo.api.orders;



import com.itq.demo.model.Order;
import org.springframework.data.domain.Page;


public interface FindAllOrdersInbound {
    public Page<Order> execute(int offset, int limit);
}
