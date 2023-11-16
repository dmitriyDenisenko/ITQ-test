package com.itq.demo.impl.orderDetails;

import com.itq.demo.api.orderDetails.FindAllOrderDetailsInbound;
import com.itq.demo.api.orderDetails.OrderDetailsRepository;
import com.itq.demo.model.OrderDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FindAllOrderDetailsUseCase implements FindAllOrderDetailsInbound {
    private final OrderDetailsRepository orderDetailsRepository;


    @Override
    public Page<OrderDetail> execute(int offset, int limit) {
        return orderDetailsRepository.findAllDetails(offset,limit);
    }
}
