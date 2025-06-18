package com.cqrs.demo.domain;

import com.cqrs.demo.infrastructure.entities.OrderEntity;
import com.cqrs.demo.infrastructure.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddOrderCommand {

    private final OrderRepository orderRepository;
//    private final StreamBrige streamBrige; // ToDO : materialized view approach can be updated to this

    public UUID execute(Input input) {
        final var result = UUID.randomUUID();
        final var orderEntity = new OrderEntity(result, input.firstName, input.lastName, input.country);
        orderRepository.save(orderEntity);
//        streamBrige.send("order-topic", new OrderUpdateEvent(uuid);
        return result;
    }

    public record Input(
            String firstName,
            String lastName,
            String country) {
    }
}
