package com.cqrs.demo.controller;

import com.cqrs.demo.dto.OrderStatus;
import com.cqrs.demo.service.GetOrderByIdQuery;
import com.cqrs.demo.service.GetOrdersQuery;

import java.util.UUID;

record OrderResponse(
        UUID id,
        OrderStatus status,
        String name,
        String lastName,
        String country,
        long createdOn
) {
    static OrderResponse of(GetOrderByIdQuery.Output output) {
        return new OrderResponse(
                output.getId(),
                output.getStatus(),
                output.getFirstName(),
                output.getLastName(),
                output.getCountry(),
                output.getCreatedOn()
        );
    }

    static OrderResponse of(GetOrdersQuery.Output output) {
        return new OrderResponse(
                output.getId(),
                output.getStatus(),
                output.getFirstName(),
                output.getLastName(),
                output.getCountry(),
                output.getCreatedOn()
        );
    }
}
