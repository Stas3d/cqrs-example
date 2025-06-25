package com.cqrs.demo.domain;

import com.cqrs.demo.infrastructure.store.entities.OrderEntity;
import com.cqrs.demo.infrastructure.store.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class AddOrderCommand {

    private final OrderRepository orderRepository;

    public UUID execute(Input input) {
        final var uuid = UUID.randomUUID();
        final var orderEntity = new OrderEntity(uuid, input.firstName, input.lastName, input.country);
        orderRepository.save(orderEntity);
        return uuid;
    }

    public record Input(
            String firstName,
            String lastName,
            String country
    ) {
    }
}
