package com.cqrs.demo.infrastructure.store.repositories;

import com.cqrs.demo.infrastructure.store.entities.OrderViewEntity;

public interface OrderReadOnlyRepository extends OrderViewRepository<OrderViewEntity, Long> {
}
