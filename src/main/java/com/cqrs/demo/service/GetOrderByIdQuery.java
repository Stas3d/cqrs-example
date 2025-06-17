package com.cqrs.demo.service;

import com.cqrs.demo.dto.OrderDto;
import com.cqrs.demo.dto.OrderStatus;
import com.cqrs.demo.repo.OrderReadOnlyRepository;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetOrderByIdQuery {
    private final OrderReadOnlyRepository readOnlyRepository;
    private final OrderConverter converter;

    public Output execute(Long id) {
        final var orderEntity = readOnlyRepository.findById(id).orElseThrow();
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
        long createdOn;

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
