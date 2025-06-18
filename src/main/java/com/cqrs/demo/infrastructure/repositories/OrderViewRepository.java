package com.cqrs.demo.infrastructure.repositories;

import com.cqrs.demo.infrastructure.entities.OrderViewEntity;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean // READ ONLY CrudRepository !
interface OrderViewRepository<OrderMVEntity, Long> extends Repository<OrderViewEntity, Long> {

    Optional<OrderMVEntity> findById(long id);

    Optional<OrderMVEntity> findByOrderNumber(UUID uuid);

    List<OrderMVEntity> findAll();
}
