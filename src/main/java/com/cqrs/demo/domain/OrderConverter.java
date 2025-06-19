package com.cqrs.demo.domain;

import com.cqrs.demo.dto.OrderDto;
import com.cqrs.demo.infrastructure.entities.OrderViewEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderConverter {

    public OrderDto fromEntity(OrderViewEntity entity) {
        return new OrderDto(
                entity.getOrderNumber(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getCountry(),
                entity.getStatus(),
                getCreatedAt(entity));
    }

    private static Long getCreatedAt(OrderViewEntity entity) {
        return entity.getCreatedAt() != null ? entity.getCreatedAt().getTime() : null;
    }
}
