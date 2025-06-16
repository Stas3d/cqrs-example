package com.cqrs.demo.dto;

import java.util.UUID;

public record OrderDto(
        UUID orderNumber,
        String name,
        String lastName,
        String country,
        OrderStatus status,
        String time) {
}
