package com.cqrs.demo.service;

import com.cqrs.demo.dto.OrderDto;
import com.cqrs.demo.repo.OrderEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderConverter {

    public OrderDto fromEntity(OrderEntity entity) {
        return new OrderDto(
                entity.getOrderNumber(),
                entity.getName(),
                entity.getLastName(),
                entity.getCountry(),
                entity.getStatus(),
                entity.getTime());
    }
}
