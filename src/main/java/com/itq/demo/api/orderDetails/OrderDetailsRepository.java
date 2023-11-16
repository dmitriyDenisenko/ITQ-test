package com.itq.demo.api.orderDetails;

import com.itq.demo.model.OrderDetail;
import org.springframework.data.domain.Page;

public interface OrderDetailsRepository {
    public Page<OrderDetail> findAllDetails(int offset, int limit);
}
