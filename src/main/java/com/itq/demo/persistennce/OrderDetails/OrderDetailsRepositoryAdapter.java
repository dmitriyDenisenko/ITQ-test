package com.itq.demo.persistennce.OrderDetails;

import com.itq.demo.api.orderDetails.OrderDetailsRepository;
import com.itq.demo.model.OrderDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderDetailsRepositoryAdapter implements OrderDetailsRepository {
    private final OrderDetailsRepositoryJpa orderDetailsRepositoryJpa;

    @Override
    public Page<OrderDetail> findAllDetails(int offset, int limit) {
        return orderDetailsRepositoryJpa.findAll(PageRequest.of(offset, limit));
    }
}
