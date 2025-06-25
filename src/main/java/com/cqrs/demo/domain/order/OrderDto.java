package com.cqrs.demo.domain.order;

import java.util.UUID;

public record OrderDto(
        UUID orderNumber,
        String firstName,
        String lastName,
        String country,
        OrderStatus status,
        Long created
) {
}
