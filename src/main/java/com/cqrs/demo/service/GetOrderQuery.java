package com.cqrs.demo.service;

import com.cqrs.demo.dto.OrderDto;
import com.cqrs.demo.dto.OrderStatus;
import com.cqrs.demo.repo.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetOrderQuery {
    private final OrderRepository repository;
    private final OrderConverter orderConverter;

    public Output execute(Long id) {
        final var orderEntity = repository.findById(id).orElseThrow();
        final var orderDto = orderConverter.fromEntity(orderEntity);
        return Output.of(orderDto);
    }

    @Value
    public static class Output {
        UUID id;
        String firstName;
        String lastName;
        String country;
        OrderStatus status;
        String time;

        static Output of(OrderDto dto) {
            return new Output(
                    dto.orderNumber(),
                    dto.firstName(),
                    dto.lastName(),
                    dto.country(),
                    dto.status(),
                    dto.time()
            );
        }
    }
}
