package com.cqrs.demo.domain;

import com.cqrs.demo.domain.order.OrderDto;
import com.cqrs.demo.domain.order.OrderStatus;
import com.cqrs.demo.infrastructure.store.repositories.OrderReadOnlyRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetOrdersQuery {
    private final OrderReadOnlyRepository repository;
    private final OrderConverter converter;

    public List<Output> execute() {
        return repository.findAll()
                .stream()
                .map(converter::fromEntity)
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
        Long createdAt;

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
