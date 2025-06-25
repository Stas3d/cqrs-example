package com.cqrs.demo.domain;

import com.cqrs.demo.domain.order.OrderDto;
import com.cqrs.demo.domain.order.OrderStatus;
import com.cqrs.demo.infrastructure.store.repositories.OrderReadOnlyRepository;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetOrderByIdQuery {
    private final OrderReadOnlyRepository readOnlyRepository;
    private final OrderConverter converter;

    public Output execute(UUID uuid) {
        final var orderEntity = readOnlyRepository.findByOrderNumber(uuid).orElseThrow();
        final var orderDto = converter.fromEntity(orderEntity);
        return Output.of(orderDto);
    }

    @Value
    public static class Output {
        UUID id;
        String firstName;
        String lastName;
        String country;
        OrderStatus status;
        Long createdAt;

        static Output of(OrderDto dto) {
            return new Output(
                    dto.orderNumber(),
                    dto.firstName(),
                    dto.lastName(),
                    dto.country(),
                    dto.status(),
                    dto.created()
            );
        }
    }
}
