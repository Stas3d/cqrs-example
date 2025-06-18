package com.cqrs.demo.infrastructure.repositories;

import com.cqrs.demo.infrastructure.entities.OrderViewEntity;

public interface OrderReadOnlyRepository extends OrderViewRepository<OrderViewEntity, Long> {
}
