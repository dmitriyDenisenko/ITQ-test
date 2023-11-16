package com.itq.demo.api.orderDetails;

import com.itq.demo.model.OrderDetail;
import org.springframework.data.domain.Page;

public interface FindAllOrderDetailsInbound {
    public Page<OrderDetail> execute(int offset, int limit);
}
