package com.cqrs.demo.domain;

import com.cqrs.demo.infrastructure.store.entities.OrderViewEntity;
import com.cqrs.demo.infrastructure.store.repositories.OrderReadOnlyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetOrderByIdQueryTest {

    private static final UUID uuid = UUID.randomUUID();

    @Test
    void shouldGetOrder(@Mock OrderReadOnlyRepository repository) {
        final var viewEntity = new OrderViewEntity(uuid, "UA", "f", "l");
        when(repository.findByOrderNumber(any())).thenReturn(Optional.of(viewEntity));

        final var query = new GetOrderByIdQuery(repository, new OrderConverter());
        final var result = query.execute(uuid);

        assertEquals(result.getId(), uuid);
    }
}
