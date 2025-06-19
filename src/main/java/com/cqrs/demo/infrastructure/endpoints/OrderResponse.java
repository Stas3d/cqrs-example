package com.cqrs.demo.infrastructure.endpoints;

import com.cqrs.demo.dto.OrderStatus;
import com.cqrs.demo.domain.GetOrderByIdQuery;
import com.cqrs.demo.domain.GetOrdersQuery;

import java.util.UUID;

record OrderResponse(
        UUID id,
        OrderStatus status,
        String name,
        String lastName,
        String country,
        Long createdOn
) {
    static OrderResponse of(GetOrderByIdQuery.Output output) {
        return new OrderResponse(
                output.getId(),
                output.getStatus(),
                output.getFirstName(),
                output.getLastName(),
                output.getCountry(),
                output.getCreatedAt()
        );
    }

    static OrderResponse of(GetOrdersQuery.Output output) {
        return new OrderResponse(
                output.getId(),
                output.getStatus(),
                output.getFirstName(),
                output.getLastName(),
                output.getCountry(),
                output.getCreatedAt()
        );
    }
}
