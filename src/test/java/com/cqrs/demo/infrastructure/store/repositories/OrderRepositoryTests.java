package com.cqrs.demo.infrastructure.store.repositories;

import com.cqrs.demo.configuration.AppTestConfiguration;
import com.cqrs.demo.infrastructure.store.entities.OrderEntity;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest(properties = {
        "spring.liquibase.enabled=false"
})
@Import(AppTestConfiguration.class)
public class OrderRepositoryTests {

    @Autowired
    private OrderRepository repository;

    @Test
    void whenCallSave_thenCorrectNumberOfOrdersPersisted() {
        repository.save(new OrderEntity(UUID.randomUUID(), "first name", "lastName", "UA"));
        repository.save(new OrderEntity(UUID.randomUUID(), "another name", "lastName", "UA"));

        final var estimateSize = repository.findAll().spliterator().estimateSize();
        assertEquals(estimateSize, 2);
    }
}
