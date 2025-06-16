package com.cqrs.demo.controller;

import com.cqrs.demo.dto.OrderStatus;
import com.cqrs.demo.service.GetOrderQuery;
import lombok.Value;

import java.util.UUID;

@Value
class OrderResponse {
    UUID id;
    OrderStatus status;
    String name;
    String lastName;
    String country;
    String time;

    static OrderResponse of(GetOrderQuery.Output output) {
        return new OrderResponse(
                output.getId(),
                output.getStatus(),
                output.getName(),
                output.getLastName(),
                output.getCountry(),
                output.getTime()
        );
    }
}
