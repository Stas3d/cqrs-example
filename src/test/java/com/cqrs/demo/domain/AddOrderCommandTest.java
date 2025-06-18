package com.cqrs.demo.domain;

import com.cqrs.demo.infrastructure.entities.OrderEntity;
import com.cqrs.demo.infrastructure.repositories.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddOrderCommandTest {

    @Test
    void shouldAddNewOrder(@Mock OrderRepository repository) {

        when(repository.save(any())).thenReturn(new OrderEntity());
        final var command = new AddOrderCommand(repository);
        final var input = new AddOrderCommand.Input("first", "last", "US");
        final var output = command.execute(input);
        assertNotNull(output);
    }
}
