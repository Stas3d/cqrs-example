package com.cqrs.demo.dto;

import java.util.UUID;

public record OrderDto(
        UUID orderNumber,
        String firstName,
        String lastName,
        String country,
        OrderStatus status,
        String time) {
}
