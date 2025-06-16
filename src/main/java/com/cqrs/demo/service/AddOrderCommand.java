package com.cqrs.demo.service;

import com.cqrs.demo.dto.OrderStatus;
import com.cqrs.demo.repo.OrderEntity;
import com.cqrs.demo.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddOrderCommand {

    private final OrderRepository orderRepository;
//    private final StreamBrige streamBrige;

    public UUID execute(Input input) {
        final var uuid = UUID.randomUUID();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderNumber(uuid);
        orderEntity.setName(input.name);
        orderEntity.setLastName(input.lastName);
        orderEntity.setCountry(input.country);
        orderEntity.setStatus(OrderStatus.CREATED);
        orderEntity.setTime(null);
        orderRepository.save(orderEntity);
//        streamBrige.send("order-topic", new OrderUpdateEvent(uuid);
        return uuid;
    }

    public record Input(
            String orderNumber,
            String name,
            String lastName,
            String country,
            String status) {
    }
}
