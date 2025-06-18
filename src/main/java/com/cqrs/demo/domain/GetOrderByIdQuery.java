package com.cqrs.demo.domain;

import com.cqrs.demo.dto.OrderDto;
import com.cqrs.demo.dto.OrderStatus;
import com.cqrs.demo.infrastructure.repositories.OrderReadOnlyRepository;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetOrderByIdQuery {
    private final OrderReadOnlyRepository repository;
    private final OrderConverter converter;

    public Output execute(Long id) {
        final var orderEntity = repository.findById(id).orElseThrow();
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
        long createdAt;

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
