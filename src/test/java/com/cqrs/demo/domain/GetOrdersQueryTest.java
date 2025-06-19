package com.cqrs.demo.domain;

import com.cqrs.demo.dto.OrderStatus;
import com.cqrs.demo.infrastructure.entities.OrderViewEntity;
import com.cqrs.demo.infrastructure.repositories.OrderReadOnlyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetOrdersQueryTest {

    private static final UUID uuid = UUID.randomUUID();

    @Test
    void shouldGetOrdersList(@Mock OrderReadOnlyRepository repository) {
        final var viewEntity = new OrderViewEntity();
        viewEntity.setOrderNumber(uuid);
        viewEntity.setCountry("UA");
        viewEntity.setFirstName("f");
        viewEntity.setLastName("l");
        viewEntity.setStatus(OrderStatus.PROCESSED);
        viewEntity.setCreatedAt(new Date());

        final var list = new ArrayList<OrderViewEntity>();
        list.add(viewEntity);

        when(repository.findAll()).thenReturn(list);

        final var query = new GetOrdersQuery(repository, new OrderConverter());
        final var result = query.execute();

        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getId(), uuid);
        assertEquals(result.get(0).getStatus(), OrderStatus.PROCESSED);
        assertEquals(result.get(0).getCountry(), "UA");
        assertEquals(result.get(0).getLastName(), "l");
        assertEquals(result.get(0).getFirstName(), "f");
    }
}
