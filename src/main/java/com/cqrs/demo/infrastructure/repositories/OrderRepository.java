package com.cqrs.demo.infrastructure.repositories;

import com.cqrs.demo.infrastructure.entities.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

}