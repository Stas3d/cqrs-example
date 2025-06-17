package com.cqrs.demo.service;

import com.cqrs.demo.dto.OrderDto;
import com.cqrs.demo.repo.OrderEntity;
import com.cqrs.demo.repo.OrderViewEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderConverter {

    public OrderDto fromEntity(OrderEntity entity) {
        return new OrderDto(
                entity.getOrderNumber(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getCountry(),
                entity.getStatus(),
                entity.getCreatedOn().getTime());
    }

    public OrderDto fromEntity(OrderViewEntity entity) {
        return new OrderDto(
                entity.getOrderNumber(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getCountry(),
                entity.getStatus(),
                entity.getCreatedOn().getTime());
    }
}
