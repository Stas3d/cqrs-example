package com.cqrs.demo.service;

import com.cqrs.demo.dto.OrderDto;
import com.cqrs.demo.dto.OrderStatus;
import com.cqrs.demo.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class GetOrdersQuery {
    private final OrderRepository repository;
    private final OrderConverter orderConverter;

    public List<Output> execute() {
        final var orderEntities = repository.findAll();
        return StreamSupport.stream(orderEntities.spliterator(), false)
                .map(orderConverter::fromEntity)
                .map(Output::of)
                .collect(Collectors.toList());
    }

    @Value
    public static class Output {
        UUID id;
        String firstName;
        String lastName;
        String country;
        OrderStatus status;
        long createdOn;

        static GetOrdersQuery.Output of(OrderDto dto) {
            return new GetOrdersQuery.Output(
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
